package cn.com.myproject.qd.weixin.mp.config;

import com.hnqianxu.djzs.redis.IRedisService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.chanjar.weixin.common.enums.TicketType;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.integration.redis.util.RedisLockRegistry;

import java.util.concurrent.TimeUnit;

/**
 * @author xx
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MyWxMpRedisConfigImpl extends WxMpDefaultConfigImpl {
    private static final String ACCESS_TOKEN_KEY_TPL = "%s:access_token:%s";
    private static final String TICKET_KEY_TPL = "%s:ticket:key:%s:%s";
    private static final String LOCK_KEY_TPL = "%s:lock:%s:";


    private final String keyPrefix;

    private String accessTokenKey;
    private String lockKey;


    private RedisLockRegistry redisLockRegistry;

    private IRedisService redisService;

    public MyWxMpRedisConfigImpl(RedisLockRegistry redisLockRegistry,
                                 IRedisService redisService,
                                 String keyPrefix) {
        this.redisLockRegistry = redisLockRegistry;
        this.redisService = redisService;
        this.keyPrefix = keyPrefix;
    }

    /**
     * 每个公众号生成独有的存储key.
     */
    @Override
    public void setAppId(String appId) {
        super.setAppId(appId);
        this.accessTokenKey = String.format(ACCESS_TOKEN_KEY_TPL, this.keyPrefix, appId);
        this.lockKey = String.format(LOCK_KEY_TPL, this.keyPrefix, appId);

        accessTokenLock = redisLockRegistry.obtain(lockKey.concat("accessTokenLock"));
        jsapiTicketLock = redisLockRegistry.obtain(lockKey.concat("jsapiTicketLock"));
        sdkTicketLock = redisLockRegistry.obtain(lockKey.concat("sdkTicketLock"));
        cardApiTicketLock = redisLockRegistry.obtain(lockKey.concat("cardApiTicketLock"));
    }

    private String getTicketRedisKey(TicketType type) {
        return String.format(TICKET_KEY_TPL, this.keyPrefix, appId, type.getCode());
    }

    @Override
    public String getAccessToken() {
        return redisService.getValue(this.accessTokenKey);
    }

    @Override
    public boolean isAccessTokenExpired() {
        Long expire = redisService.getExpire(this.accessTokenKey);
        return expire == null || expire < 2;
    }

    @Override
    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        redisService.setValue(this.accessTokenKey, accessToken, expiresInSeconds - 200, TimeUnit.SECONDS);
    }

    @Override
    public void expireAccessToken() {
        redisService.expire(this.accessTokenKey, 0, TimeUnit.SECONDS);
    }

    @Override
    public String getTicket(TicketType type) {
        return redisService.getValue(this.getTicketRedisKey(type));
    }

    @Override
    public boolean isTicketExpired(TicketType type) {
        return redisService.getExpire(this.getTicketRedisKey(type)) < 2;
    }

    @Override
    public synchronized void updateTicket(TicketType type, String jsapiTicket, int expiresInSeconds) {
        redisService.setValue(this.getTicketRedisKey(type), jsapiTicket, expiresInSeconds - 200, TimeUnit.SECONDS);
    }

    @Override
    public void expireTicket(TicketType type) {
        redisService.expire(this.getTicketRedisKey(type), 0, TimeUnit.SECONDS);
    }

}

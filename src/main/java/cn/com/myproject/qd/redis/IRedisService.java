package cn.com.myproject.qd.redis;

import org.springframework.data.geo.GeoResult;
import org.springframework.data.redis.connection.RedisGeoCommands;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author xx
 * @date 2017/6/22
 */
public interface IRedisService {

    Boolean setValue(String key, String value);

    Boolean setValue(String key, String value, long timeOut);

    Boolean setValue(String key, String value, long timeOut, TimeUnit timeUnit);

    String getValue(String key);

    void setHashValue(String key, String hashKey, Object value);

    void setHashAll(String key, Map<String, Object> map);

    void setHashAllString(String key, Map<String, String> map);

    Object getHashValue(String key, String hashKey);

    Set<Object> getKey(String key);

    void delete(String key);

    /**
     * delHashValue
     * @param key
     * @param hashKey
     */
    void delHashValue(String key, String hashKey);

    Boolean containKey(String key);
    /**
     * getEntries
     * @param key
     * @return
     */
    Map<Object, Object> getEntries(String key);

    /**
     * 监控
     * @param key
     */
    void watch(String key);

    /**
     * 事务开始
     */
    void multi();

    /**
     * 解除监控
     */
    void unWatch();

    /**
     * 事务提交
     * @return
     */
    List<Object> exec();

    /**
     * 原子递增
     * */
    Long increment(String key);
    /**
     * 原子增减
     * */
    Double increment(String key, double b);

    Double hashIncrement(String key, String hashKey, double b);

    Long getExpire(String key);

    boolean expire(String key, long timeout, TimeUnit unit);


    void addGeo(String key, double lon, double lat, String member);

    void removeGeo(String key, String member);


    /**
     *  @param key
     * @param lon
     * @param lat
     * @param distance  查询范围 (单位：KM)
     * @param num 返回结果的个数（>=1）
     * @return
     */
    List<GeoResult<RedisGeoCommands.GeoLocation<Object>>> listGeo(String key, double lon, double lat, int distance, int num);
}

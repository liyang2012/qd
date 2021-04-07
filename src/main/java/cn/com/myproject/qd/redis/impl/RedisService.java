package cn.com.myproject.qd.redis.impl;



import cn.com.myproject.qd.redis.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by x1 on 2017/6/22.
 */
@Service("redisService")
public class RedisService implements IRedisService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Boolean setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return redisTemplate.hasKey(key);
    }

    @Override
    public Boolean setValue(String key, String value,long timeOut) {
        redisTemplate.opsForValue().set(key, value, timeOut, TimeUnit.MINUTES);
        return redisTemplate.hasKey(key);
    }
    @Override
    public Boolean setValue(String key, String value, long timeOut, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeOut, timeUnit);
        return redisTemplate.hasKey(key);
    }

    @Override
    public String getValue(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        return o == null ? null : o.toString();
    }

    @Override
    public void setHashValue(String key, String hashKey, Object value){
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

       @Override
    public void setHashAll(String key,Map<String,Object> map){
        redisTemplate.opsForHash().putAll(key,map);
    }

    @Override
    public void setHashAllString(String key,Map<String,String> map){
        redisTemplate.opsForHash().putAll(key,map);
    }

    @Override
    public Object getHashValue(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key,hashKey);
    }

    @Override
    public Set<Object> getKey(String key){
        return redisTemplate.opsForHash().keys(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void delHashValue(String key, String hashKey) {
        redisTemplate.opsForHash().delete(key,hashKey);
    }

    @Override
    public Boolean containKey(String key) {
        return redisTemplate.hasKey(key);
    }
    @Override
    public Map<Object, Object> getEntries(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public  void watch(String key){
        redisTemplate.watch(key);
    }

    @Override
    public void multi(){
        redisTemplate.multi();
    }

    @Override
    public void unWatch() {
        redisTemplate.unwatch();
    }

    @Override
    public List<Object> exec() {
        return redisTemplate.exec();
    }

    @Override
    public Long increment(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    @Override
    public Double increment(String key,double b) {
        return redisTemplate.opsForValue().increment(key,b);
    }

    @Override
    public Double hashIncrement(String key,String hashKey,double b) {
        return redisTemplate.opsForHash().increment(key,hashKey,b);
    }

    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    @Override
    public boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    @Override
    public void addGeo(String key, double lon, double lat, String member) {
        Point point = new Point(lon, lat);
        redisTemplate.boundGeoOps(key).add(point, member);
    }

    @Override
    public void removeGeo(String key, String member) {
        redisTemplate.boundGeoOps(key).remove(member);
    }

    @Override
    public List<GeoResult<RedisGeoCommands.GeoLocation<Object>>> listGeo(String key, double lon, double lat, int distance, int num) {

        Circle circle = new Circle(new Point(lon, lat), new Distance(distance, Metrics.KILOMETERS));
        GeoResults<RedisGeoCommands.GeoLocation<Object>> list = redisTemplate.boundGeoOps(key).
                radius(circle, RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().limit(num).includeDistance());
        return list.getContent();
    }
}

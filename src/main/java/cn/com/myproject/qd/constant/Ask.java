package cn.com.myproject.qd.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

public class Ask {
    private static final Logger logger = LoggerFactory.getLogger(Ask.class);

    private static ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>(128);

    public static void put(String phone){
        if(map.containsKey(phone)) {
            map.put(phone,map.get(phone)+1);
        }else{
            map.put(phone,1);
        }
        logger.info("请求添加,{}",phone);

    }

    public static ConcurrentHashMap<String,Integer> get(){
      return map;
    }

    public static boolean contain(String phone){
        return map.containsKey(phone);
    }

    public static void clear() {
        map.clear();
        map = new ConcurrentHashMap<>(128);
    }

}

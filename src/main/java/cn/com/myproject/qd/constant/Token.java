package cn.com.myproject.qd.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

public class Token {
    private static final Logger logger = LoggerFactory.getLogger(Token.class);
    private static ConcurrentHashMap<String,String[]> map = new ConcurrentHashMap<>(128);

    public static void put(String phone,String token,String num){
        map.put(phone,new String[]{token,num});
        logger.info("登录token添加{},{},{}",phone,token,num);

    }

    public static ConcurrentHashMap<String,String[]> get(){
      return map;
    }

    public static void clear() {
        map.clear();
        map = new ConcurrentHashMap<>(128);
    }

}

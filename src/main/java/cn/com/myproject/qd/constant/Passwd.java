package cn.com.myproject.qd.constant;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Passwd {
//    public static Map<String,String[]> map = new HashMap<>();
//    //下午
//    public static Map<String,String[]> map1 = new HashMap<>();
//    //晚上
//    public static Map<String,String[]> map2 = new HashMap<>();
//
//    public static Map<String,String[]> map298 = new HashMap<>();

    public static AtomicInteger goodsId = new AtomicInteger(-999);
    public static AtomicInteger promType = new AtomicInteger(-999);
    public static AtomicInteger specId = new AtomicInteger(-999);


    public static AtomicInteger goodsId298 = new AtomicInteger(-999);

    public static Set<Integer> specIdSet = new ConcurrentHashMap().keySet(16);

    public static final String userAgent = "1.0.43 rv:0.0.1 (iPhone; iOS 13.3.1; zh_CN)";
    public static final String contentType = "application/x-www-form-urlencoded; charset=utf-8";

}

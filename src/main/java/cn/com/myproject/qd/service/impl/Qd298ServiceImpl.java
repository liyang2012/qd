package cn.com.myproject.qd.service.impl;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.service.IQd298Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class Qd298ServiceImpl implements IQd298Service{
    private static final Logger logger = LoggerFactory.getLogger(Qd298ServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Async("asyncQd298ServiceExecutor")
    @Override
    public void qd(String token, int num) {
        long l = System.currentTimeMillis();
        String url;
        JSONObject postData = null;
        ResponseEntity<String> entity = null;
        Integer addressId = 0;
        Integer goodsPrice = 298;
        if(Passwd.goodsId298.get()==-999) {
            url = "http://www.xtxbc.com/api/app/new_lists/getStoreGoodsList";
            for(int i=1;i<6;i++) {
                getGoodsId(url,postData,entity,token,i,goodsPrice);
                if(Passwd.goodsId298.get()!=-999) {
                    break;
                }
            }
            if(Passwd.goodsId298.get()==-999) {
                logger.info("没有获取到商品，{}",System.currentTimeMillis()-l);
                return;
            }

        }else {
            logger.info("已获取属性，直接下单...................");
        }
       //获取商品详情
        url = "http://www.xtxbc.com/app/user/getConfirmOrderPageInfos";
        postData = new JSONObject();
        postData.put("token", token);
        postData.put("goods_id",  "[{\"id\":"+ Passwd.goodsId298.get()+",\"num\":"+num+"}]");
        postData.put("info_type", "goods");
        postData.put("address_id", "");
        postData.put("spec_id", "0");
        entity = restTemplate.postForEntity(url, postData, String.class);
        JSONObject jo1 = JSON.parseObject(entity.getBody()).getJSONObject("data");

        try {
            addressId = jo1.getJSONObject("address").getInteger("address_id");

        }catch (Exception e){
            logger.info("解析详情错误",e);
        }
        logger.info("addressId={}",addressId);
        //下单
        url = "http://www.xtxbc.com/app/user/generateOrderAndToBePaids";
        postData = new JSONObject();
        postData.put("key_id", "0");
        postData.put("goods_id", "[{\"id\":"+ Passwd.goodsId298.get()+",\"num\":"+num+"}]");
        postData.put("fast_price", "0");
        postData.put("fast_pay", goodsPrice+".00");
        postData.put("coupon_price", "0");
        postData.put("info_type", "goods");
        postData.put("address_id", addressId);
        postData.put("token", token);
        entity = restTemplate.postForEntity(url, postData, String.class);
        logger.info("返回日志：{},{},{}",token,entity.getBody(),System.currentTimeMillis()-l);

    }
    private void getGoodsId(String url,JSONObject postData,ResponseEntity<String> entity,String token,Integer page,
                            Integer goodsPrice){
        postData = new JSONObject();
        postData.put("page", page);
        postData.put("token", token);
        postData.put("category_id", -2);
        entity = restTemplate.postForEntity(url, postData, String.class);
        String room = entity.getBody();
        JSONObject jo = JSON.parseObject(room);
        JSONArray ja = jo.getJSONObject("data").getJSONArray("goods_info");
        for(int i=0;i<ja.size();i++) {
            JSONObject _jo = ja.getJSONObject(i);
            if(_jo.getBigDecimal("shop_price").compareTo(BigDecimal.valueOf(goodsPrice)) == 0){
                Passwd.goodsId298.set( _jo.getInteger("goods_id"));
                break;
            }
        }
    }
}

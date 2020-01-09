package cn.com.myproject.qd.service.impl;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.service.ISearchService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author liyang-macbook
 */
@Service
public class SearchServiceImpl implements ISearchService {
    private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Async("asyncSearchServiceExecutor")
    @Override
    public void qd(String token) {
        long l = System.currentTimeMillis();
        String url;
//        JSONObject postData;
        ResponseEntity<String> entity = null;
        if(Passwd.goodsId.get()==-999 || Passwd.promType.get()==-999 || Passwd.specId.get()==-999) {
            url = "http://www.xtxbc.com/api/app/new_lists/getStoreGoodsList";
//            postData = new JSONObject();
//            postData.put("page", 1);
//            postData.put("category_id", -3);

            MultiValueMap<String,String> map = new LinkedMultiValueMap<String, String>();
            map.set("page", "1");
            map.set("category_id", "-3");

            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent","1.0.38 rv:0.0.1 (iPhone; iOS 13.3; zh_CN)");
            headers.set("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
            HttpEntity< MultiValueMap<String,String>> e = new HttpEntity<>(map, headers);

            entity = restTemplate.postForEntity(url, e, String.class);
            String room = entity.getBody();
            JSONObject jo = JSON.parseObject(room);
            JSONArray ja = jo.getJSONObject("data").getJSONArray("goods_info");
            for(int i=0;i<ja.size();i++) {
                JSONObject _jo = ja.getJSONObject(i);
                if(_jo.getInteger("goods_id") != 59 && _jo.getInteger("goods_id") != 119){
                    Passwd.goodsId.set( _jo.getInteger("goods_id"));
                    break;
                }
            }
            if(Passwd.goodsId.get()==-999) {
                logger.info("没有获取到商品，{}",System.currentTimeMillis()-l);
                return;
            }
            //获取商品详情
            url = "http://www.xtxbc.com/app/Cron/wogetGoodsDetail";
//            postData = new JSONObject();
//            postData.put("token", token);
//            postData.put("goods_id", Passwd.goodsId.get());

            map = new LinkedMultiValueMap<String, String>();
            map.set("token", token);
            map.set("goods_id", Passwd.goodsId.get()+"");

            headers = new HttpHeaders();
            headers.set("User-Agent","1.0.38 rv:0.0.1 (iPhone; iOS 13.3; zh_CN)");
            headers.set("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
            e = new HttpEntity<>(map, headers);

            entity = restTemplate.postForEntity(url, e, String.class);
            JSONObject jo1 = JSON.parseObject(entity.getBody()).getJSONObject("data");
            //购买数量
            int prom_type = 0;
            int spec_id = 0;
            try {
                prom_type = jo1.getInteger("prom_type");
                spec_id = jo1.getJSONArray("goods_spec_list").getJSONArray(0).getJSONObject(0).getInteger("item_id");
                Passwd.promType.set(prom_type);
                Passwd.specId.set(spec_id);
            }catch (Exception e1){
                logger.info("解析详情错误",e1);
            }
            logger.info("prom_type={},spce_id={}",prom_type,spec_id);
        }else {
            logger.info("已获取属性，不需要请求...................");
        }
        logger.info("返回日志：{},{},{}",token,entity.getBody(),System.currentTimeMillis()-l);
    }

}

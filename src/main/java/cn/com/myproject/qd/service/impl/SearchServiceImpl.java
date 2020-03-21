package cn.com.myproject.qd.service.impl;

import cn.com.myproject.qd.constant.Ask;
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

import java.lang.reflect.Executable;

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
    public void qd(String phone,String token) {
        long l = System.currentTimeMillis();
        String url;

        ResponseEntity<String> entity = null;
        HttpHeaders headers = null;
        MultiValueMap<String, String> map = null;
        HttpEntity<MultiValueMap<String, String>> e = null;
        if(Passwd.goodsId.get()==-999) {
            url = "http://www.xtxbc.com/api/app/new_lists/getStoreGoodsList_new";

            map = new LinkedMultiValueMap<String, String>();
            map.set("page", "1");
            map.set("category_id", "-3");
            map.set("token", token);

            headers = new HttpHeaders();
            headers.set("User-Agent", Passwd.userAgent);
            headers.set("Content-Type", Passwd.contentType);
            e = new HttpEntity<>(map, headers);

            entity = restTemplate.postForEntity(url, e, String.class);
            String room = entity.getBody();
            try {
                JSONObject jo = JSON.parseObject(room);
                JSONArray ja = jo.getJSONObject("data").getJSONArray("goods_info");
                for (int i = 0; i < ja.size(); i++) {
                    JSONObject _jo = ja.getJSONObject(i);
                    if (_jo.getInteger("goods_id") != 59 && _jo.getInteger("goods_id") != 119) {
                        Passwd.goodsId.set(_jo.getInteger("goods_id"));
                        break;
                    }
                }
            }catch (Exception e1){
                logger.info("解析详情错误1,{},{}",phone,entity.getBody());
            }
        }
        if(Passwd.goodsId.get()==-999) {
            logger.info("没有获取到商品，{},{}",phone,System.currentTimeMillis()-l);
            return;
        }
        if(Passwd.promType.get()==-999 || Passwd.specId.get()==-999) {
            //获取商品详情
            url = "http://www.xtxbc.com/app/Cron/wogetGoodsDetail";

            map = new LinkedMultiValueMap<String, String>();
            map.set("token", token);
            map.set("goods_id", Passwd.goodsId.get()+"");

            headers = new HttpHeaders();
            headers.set("User-Agent",Passwd.userAgent);
            headers.set("Content-Type",Passwd.contentType);
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
                logger.info("解析详情错误2");
            }
            Ask.put(phone);
            logger.info("prom_type={},spce_id={}",prom_type,spec_id);
        }
        logger.info("返回日志：{},{}",token,System.currentTimeMillis()-l);
    }

}

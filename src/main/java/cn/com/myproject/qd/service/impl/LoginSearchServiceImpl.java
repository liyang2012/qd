package cn.com.myproject.qd.service.impl;


import cn.com.myproject.qd.constant.TokenS;
import cn.com.myproject.qd.service.ILoginSearchService;
import com.alibaba.fastjson.JSON;
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
 * @author ly
 */
@Service
public class LoginSearchServiceImpl implements ILoginSearchService {
    private static final Logger logger = LoggerFactory.getLogger(LoginSearchServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Async("asyncLoginSearchServiceExecutor")
    @Override
    public void login(String phone, String passwd,String num) {
        long l = System.currentTimeMillis();
        String url = "http://www.xtxbc.com/app/reg/login";

        MultiValueMap<String,String> map = new LinkedMultiValueMap<String, String>();
        map.set("password", passwd);
        map.set("phone", phone);
        map.set("registration_id", "");
        map.set("device_type", "ios");

        ResponseEntity<String> entity = null;

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent","1.0.38 rv:0.0.1 (iPhone; iOS 13.3; zh_CN)");
        headers.set("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
        HttpEntity< MultiValueMap<String,String>> e = new HttpEntity<>(map, headers);

        entity = restTemplate.postForEntity(url, e, String.class);
        String room = entity.getBody();
        JSONObject jo = JSON.parseObject(room);
        if(jo.getString("code").equals("success")){
            //获取token
            String token = jo.getString("data");
            TokenS.put(phone,token,num);
        }else{
            logger.info("登录失败，{}",phone);
        }
        logger.info("登录耗时{}：{}",phone,System.currentTimeMillis()-l);
    }
}

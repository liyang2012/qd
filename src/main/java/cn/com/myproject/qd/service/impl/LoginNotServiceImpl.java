package cn.com.myproject.qd.service.impl;

import cn.com.myproject.qd.service.ILoginNotService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * @author ly
 */
@Service
public class LoginNotServiceImpl implements ILoginNotService {
    private static final Logger logger = LoggerFactory.getLogger(LoginNotServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Async("asyncLoginNotServiceExecutor")
    @Override
    public Future<String> login(String phone, String token) {
        String url = "http://www.xtxbc.com/app/user/myPageUserInfo";
        JSONObject postData = new JSONObject();
        postData.put("token", token);

        ResponseEntity<String> entity = null;

        entity = restTemplate.postForEntity(url, postData, String.class);
        String room = entity.getBody();
        JSONObject jo = JSON.parseObject(room);
        if(jo.getString("code").equals("success")){
            //获取token

            String phoneNum = jo.getJSONObject("data").getString("phone");
            logger.info("phone:{},phoneNum:{}",phone,phoneNum);
            if(phone.equals(phoneNum.trim())){
                return new AsyncResult<String>("");
            }
        }
        return new AsyncResult<>(phone);

    }
}

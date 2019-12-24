package cn.com.myproject.qd.service.impl;

import cn.com.myproject.qd.service.IJhqdQdService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JhqdServiceImpl implements IJhqdQdService {
    private static final Logger logger = LoggerFactory.getLogger(JhqdServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void qd(String token) {
        long l = System.currentTimeMillis();
        String url;
        JSONObject postData;
        ResponseEntity<String> entity = null;

        //预约首页
        url = "http://jinianbi.ccb.com/tran/WCCMainPlatV5?CCB_IBSVersion=V5&SERVLET_NAME=WCCMainPlatV5&TXCODE=NYB001";
        entity = restTemplate.getForEntity(url,String.class);

        HttpHeaders headers = entity.getHeaders();
        //cookies
        List<String> cookies = headers.get(HttpHeaders.COOKIE);




    }
}

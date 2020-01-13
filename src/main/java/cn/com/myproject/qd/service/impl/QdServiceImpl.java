package cn.com.myproject.qd.service.impl;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.model.User;
import cn.com.myproject.qd.service.ILoginService;
import cn.com.myproject.qd.service.IQdService;
import cn.com.myproject.qd.service.IUserService;
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

@Service
public class QdServiceImpl implements IQdService{
    private static final Logger logger = LoggerFactory.getLogger(QdServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ILoginService loginService;

    @Autowired
    private IUserService userService;

    @Async("asyncQdServiceExecutor")
    @Override
    public void qd(String phone,String token, int num) {
        long l = System.currentTimeMillis();
        String url;
        JSONObject postData;
        ResponseEntity<String> entity = null;
        if(Passwd.goodsId.get()==-999 || Passwd.promType.get()==-999 || Passwd.specId.get()==-999) {
            return;
        }else {
            logger.info("已获取属性，直接下单...................");
        }

        //下单
        String info_type = "goods";
        url = "http://www.xtxbc.com/app/Cron/rushtopurchase_new";

        MultiValueMap<String,String> map = new LinkedMultiValueMap<String, String>();
        map.set("goods_nums", num+"");
        map.set("goods_id", Passwd.goodsId.get()+"");
        map.set("prom_type", Passwd.promType.get()+"");
        map.set("spec_id", Passwd.specId.get()+"");
        map.set("info_type", info_type);
        map.set("token", token);

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent","1.0.38 rv:0.0.1 (iPhone; iOS 13.3; zh_CN)");
        headers.set("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
        HttpEntity< MultiValueMap<String,String>> e = new HttpEntity<>(map, headers);
//
//        postData = new JSONObject();
//        postData.put("goods_nums", num);
//        postData.put("goods_id", Passwd.goodsId.get());
//        postData.put("prom_type", Passwd.promType.get());
//        postData.put("spec_id", Passwd.specId.get());
//        postData.put("info_type", info_type);
//        postData.put("token", token);
        entity = restTemplate.postForEntity(url, e, String.class);
        logger.info("返回日志：{},{},{},{}",phone,token,entity.getBody(),System.currentTimeMillis()-l);
        //处理配额积分不足问题
        if(entity.getBody().contains("\\u914d\\u989d\\u79ef\\u5206\\u4e0d\\u8db3")) {
            User user = userService.get(phone);

            String _url = "http://www.xtxbc.com/app/reg/login";
            MultiValueMap<String,String> _map = new LinkedMultiValueMap<String, String>();
            _map.set("password", user.getPasswd());
            _map.set("phone", phone);
            _map.set("registration_id", "");
            _map.set("device_type", "ios");

            ResponseEntity<String> _entity = null;

            HttpHeaders _headers = new HttpHeaders();
            _headers.set("User-Agent","1.0.38 rv:0.0.1 (iPhone; iOS 13.3; zh_CN)");
            _headers.set("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
            HttpEntity< MultiValueMap<String,String>> _e = new HttpEntity<>(_map, _headers);

            _entity = restTemplate.postForEntity(_url, _e, String.class);
            String room = _entity.getBody();
            JSONObject jo = JSON.parseObject(room);
            if(jo.getString("code").equals("success")){
                //获取token
                String _token = jo.getString("data");
                Integer _num = user.getNum();
                qd(phone,_token,_num);
                Token.put(phone,_token,_num+"");
                logger.info("配额积分不足再次处理，{}",phone);
            }else{
                logger.info("再次登录失败，{}",phone);
            }

        }

    }
}

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
    private IUserService userService;

    @Async("asyncQdServiceExecutor")
    @Override
    public void qd(String phone,String token, int num) {
        long l = System.currentTimeMillis();
        String url;

        ResponseEntity<String> entity = null;
        MultiValueMap<String,String> map = null;
        HttpHeaders headers = null;
        HttpEntity< MultiValueMap<String,String>> e = null;
        if(Passwd.goodsId.get()==-999) {
            url = "http://www.xtxbc.com/api/app/new_lists/getStoreGoodsList";
            map = new LinkedMultiValueMap<String, String>();
            map.set("page", "1");
            map.set("category_id", "-3");

            headers = new HttpHeaders();
            headers.set("User-Agent","1.0.38 rv:0.0.1 (iPhone; iOS 13.3; zh_CN)");
            headers.set("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
            e = new HttpEntity<>(map, headers);

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
        }
        if(Passwd.goodsId.get()==-999) {
            logger.info("没有获取到商品，{}",System.currentTimeMillis()-l);
            return;
        }
        if(Passwd.promType.get()==-999 || Passwd.specId.get()==-999) {
            String str = xiangqing(token);
            JSONObject jo1 = JSON.parseObject(str).getJSONObject("data");
            //购买数量
            int prom_type = 0;
            int spec_id = 0;
            try {
                prom_type = jo1.getInteger("prom_type");
                spec_id = jo1.getJSONArray("goods_spec_list").getJSONArray(0).getJSONObject(0).getInteger("item_id");
                Passwd.promType.set(prom_type);
                Passwd.specId.set(spec_id);
            } catch (Exception e1) {
                logger.info("解析详情错误", e1);
            }
            logger.info("prom_type={},spce_id={}", prom_type, spec_id);
            String result = xiadan(num,token);
            bujiu(result,phone);
            logger.info("返回日志：{},{},{},{}",phone,token,result,System.currentTimeMillis()-l);
            return;
        }

        logger.info("已获取属性，直接下单...................");
        xiangqing(token);
        String result = xiadan(num,token);
        bujiu(result,phone);
        logger.info("返回日志：{},{},{},{}",phone,token,result,System.currentTimeMillis()-l);



    }
    /**
     * 查看商品详情
     * */
    private String xiangqing(String token) {
        String url = "http://www.xtxbc.com/app/Cron/wogetGoodsDetail";
        MultiValueMap<String,String>  map = new LinkedMultiValueMap<String, String>();
        map.set("token", token);
        map.set("goods_id", Passwd.goodsId.get()+"");
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent","1.0.38 rv:0.0.1 (iPhone; iOS 13.3; zh_CN)");
        headers.set("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
        HttpEntity< MultiValueMap<String,String>> e = new HttpEntity<>(map, headers);
        ResponseEntity<String> entity = restTemplate.postForEntity(url, e, String.class);
        return entity.getBody();
    }

    /**
     * 下单
     * */
    private String xiadan(Integer num,String token){
        //下单
        String info_type = "goods";
        String url = "http://www.xtxbc.com/app/Cron/rushtopurchase_new";
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

        ResponseEntity<String> entity = restTemplate.postForEntity(url, e, String.class);

        return entity.getBody();
    }
    /**
     * 补救
     * */
    private void bujiu(String str,String phone) {
        //处理配额积分不足问题
        if(str.contains("\\u914d\\u989d\\u79ef\\u5206\\u4e0d\\u8db3")) {
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
                xiangqing(_token);
                logger.info("再次查询商品详情");
                xiadan(_num,_token);
                Token.put(phone,_token,_num+"");
                logger.info("配额积分不足再次处理，{}",phone);
            }else{
                logger.info("再次登录失败，{}",phone);
            }
        }
    }
}

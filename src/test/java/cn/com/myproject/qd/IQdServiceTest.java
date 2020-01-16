package cn.com.myproject.qd;


import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.service.ILoginService;
import cn.com.myproject.qd.service.IQdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IQdServiceTest {

    @Autowired
    private IQdService qdService;

    @Autowired
    private ILoginService loginService;

    @Test
    public void test(){
        Token.clear();

        loginService.login("15136753629","a123456b","2");
        Passwd.goodsId.set(318);

        Map<String,String[]> map = Token.get();
        if(map == null || map.isEmpty()) {
            return;
        }
        for(String str:map.keySet()) {
            String[] strs = map.get(str);
            qdService.qd(str,strs[0],Integer.parseInt(strs[1]));
        }

        Passwd.goodsId.set(315);

        for(String str:map.keySet()) {
            String[] strs = map.get(str);
            qdService.qd(str,strs[0],Integer.parseInt(strs[1]));
        }

        Passwd.goodsId.set(312);

        for(String str:map.keySet()) {
            String[] strs = map.get(str);
            qdService.qd(str,strs[0],Integer.parseInt(strs[1]));
        }
    }
}
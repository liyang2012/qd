package cn.com.myproject.qd;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.service.IQd298Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IQd298ServiceTest {

    @Autowired
    private IQd298Service qd298Service;
    @Test
    public void test(){
        Passwd.map298.put("18600890788",new String[]{"1qazxsw23edcp","2"});
        qd298Service.qd("MrqKgLMAc85PKV8CNZtV3r3lFhMekw",1);
    }
}
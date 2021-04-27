package cn.com.myproject.qd;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.service.IQd298Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class IQd298ServiceTest {

    @Autowired
    private IQd298Service qd298Service;
    @Test
    public void test(){

        qd298Service.qd("WGQd0wpKlrV8CPfZCCYm0BFjvmJzjE",1);
    }
}
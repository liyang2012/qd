package cn.com.myproject.qd;

import cn.com.myproject.qd.service.IJhqdQdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IJhqdServiceTest {

    @Autowired
    private IJhqdQdService jhqdQdService;
    @Test
    public void test(){

        jhqdQdService.qd("");
    }
}
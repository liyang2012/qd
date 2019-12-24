package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.model.User;
import cn.com.myproject.qd.service.ILoginService;
import cn.com.myproject.qd.service.IQdService;
import cn.com.myproject.qd.service.IUserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: x2
 * @Date: 2019/9/2 15:15
 */
public class TestJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(TestJob.class);


    @Autowired
    private ILoginService loginService;

    @Autowired
    private IUserService userService;

    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("test.............");
//        Token.clear();
//        List<User> list = userService.getAll(3);
//        for(User user:list) {
//            loginService.login(user.getPhone(),user.getPasswd(),user.getNum()+"");
//        }

    }
}

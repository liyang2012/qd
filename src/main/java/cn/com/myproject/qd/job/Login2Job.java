package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.model.User;
import cn.com.myproject.qd.service.ILoginService;
import cn.com.myproject.qd.service.IUserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: x2
 * @Date: 2019/9/2 15:15
 */
public class Login2Job implements Job {

    private static final Logger logger = LoggerFactory.getLogger(Login2Job.class);


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
        logger.info("执行登录job..............");
        Token.clear();
        Passwd.goodsId = new AtomicInteger(-999);
        Passwd.promType = new AtomicInteger(-999);
        Passwd.specId = new AtomicInteger(-999);
        List<User> list = userService.getAll(4);
        for(User user:list) {
            loginService.login(user.getPhone(),user.getPasswd(),user.getNum()+"");
        }

    }
}

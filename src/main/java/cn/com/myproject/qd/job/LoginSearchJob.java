package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.constant.TokenS;
import cn.com.myproject.qd.model.User;
import cn.com.myproject.qd.service.ILoginSearchService;
import cn.com.myproject.qd.service.ILoginService;
import cn.com.myproject.qd.service.IUserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 上午登录
 * @Author: x2
 * @Date: 2019/9/2 15:15
 */
public class LoginSearchJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(LoginSearchJob.class);


    @Autowired
    private ILoginSearchService loginSearchService;

    @Autowired
    private IUserService userService;

    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("执行查询登录job..............");
        Passwd.goodsId = new AtomicInteger(-999);
        Passwd.promType = new AtomicInteger(-999);
        Passwd.specId = new AtomicInteger(-999);
        TokenS.clear();
        List<User> list = userService.getAll(8);
        for(User user:list) {
            loginSearchService.login(user.getPhone(),user.getPasswd(),user.getNum()+"");
        }


    }
}

package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.service.ILoginService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author: x2
 * @Date: 2019/9/2 15:15
 */
public class Login1Job implements Job {

    private static final Logger logger = LoggerFactory.getLogger(Login1Job.class);


    @Autowired
    private ILoginService loginService;



    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("执行登录job..............");
        Token.clear();
        Map<String,String[]> map = Passwd.map1;
        for(String str:map.keySet()) {
            String[] strs = map.get(str);
            loginService.login(str,strs[0],strs[1]);
        }


    }
}

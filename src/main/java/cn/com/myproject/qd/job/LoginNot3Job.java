package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.model.User;
import cn.com.myproject.qd.service.ILoginNotService;
import cn.com.myproject.qd.service.ILoginService;
import cn.com.myproject.qd.service.IUserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: 上午 判断登录与否
 */
public class LoginNot3Job implements Job {

    private static final Logger logger = LoggerFactory.getLogger(LoginNot3Job.class);


    @Autowired
    private ILoginService loginService;

    @Autowired
    private ILoginNotService loginNotService;

    @Autowired
    private IUserService userService;

    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException{
        logger.info("执行判断登录与否job..............");
        ConcurrentHashMap<String,String[]> map = Token.get();
        List<Future<String>> futures = new ArrayList<>();
        for(String str : map.keySet()) {
            futures.add(loginNotService.login(str,map.get(str)[0]));
        }
        //重新登录
        for(Future<String> future : futures){
            try {
                String str = future.get();
                if(!StringUtils.isEmpty(str)) {
                    User user = userService.get(str,3);
                    loginService.login(str,user.getPasswd(),user.getNum()+"");
                }
            } catch (InterruptedException e) {
                logger.error("1",e);
            } catch (ExecutionException e) {
                logger.error("2",e);
            }

        }

    }
}

package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.constant.TokenS;
import cn.com.myproject.qd.model.User;
import cn.com.myproject.qd.service.*;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private IQdService qdService;

    @Autowired
    private ILoginSearchService loginSearchService;

    @Autowired
    private ISearchService searchService;

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
//        Token.clear();
//        loginSearchService.login("18600890788","1qazxsw23edcp","1");
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Map<String,String[]> map = TokenS.get();
//        if(map == null || map.isEmpty()) {
//            return;
//        }
//        for(String str:map.keySet()) {
//            String[] strs = map.get(str);
//            searchService.qd(strs[0]);
//        }

    }
}

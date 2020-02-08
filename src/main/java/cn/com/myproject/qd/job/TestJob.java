package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Ask;
import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.constant.Token;
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
import java.util.concurrent.atomic.AtomicInteger;

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
    private ISearchService searchService;

    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("test.............");

//        Map<String,String[]> map = Token.get();
//        if(map == null || map.isEmpty()) {
//            return;
//        }
//        logger.info("查询账号总数，{}",map.size());
//        for(String str:map.keySet()) {
//            String[] strs = map.get(str);
//            searchService.qd(str,strs[0]);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                logger.error("----",e);
//            }
//        }


    }
}

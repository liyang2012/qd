package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.service.IQd298Service;
import cn.com.myproject.qd.service.IQdService;
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
public class Qd298Job implements Job {

    private static final Logger logger = LoggerFactory.getLogger(Qd298Job.class);

    @Autowired
    private IQd298Service qd298Service;
    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("抢单job开始");
        Map<String,String[]> map = Token.get();
        for(String str:map.keySet()) {
            String[] strs = map.get(str);
            qd298Service.qd(strs[0],Integer.parseInt(strs[1]));
        }
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //再试一次
        for(String str:map.keySet()) {
            String[] strs = map.get(str);
            qd298Service.qd(strs[0],Integer.parseInt(strs[1]));
        }

    }
}

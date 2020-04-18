package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.constant.Token;
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
public class QdJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(QdJob.class);

    @Autowired
    private IQdService qdService;
    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("抢单job开始");
        Map<String,String[]> map = Token.get();
        if(map == null || map.isEmpty()) {
            return;
        }
        logger.info("抢单账号总数，{}",map.size());

        for(Map.Entry<String, String[]> entry:map.entrySet()) {
            qdService.qd(entry.getKey(), entry.getValue()[0], Integer.parseInt(entry.getValue()[1]));
        }
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            logger.error("",e);
        }
        for(Map.Entry<String, String[]> entry:map.entrySet()) {
            qdService.qd(entry.getKey(), entry.getValue()[0], Integer.parseInt(entry.getValue()[1]));
        }
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            logger.error("",e);
        }
        for(Map.Entry<String, String[]> entry:map.entrySet()) {
            qdService.qd(entry.getKey(), entry.getValue()[0], Integer.parseInt(entry.getValue()[1]));
        }


    }
}

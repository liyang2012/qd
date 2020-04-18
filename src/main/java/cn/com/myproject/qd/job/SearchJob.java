package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.service.ISearchService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author:
 * @Date:
 */
public class SearchJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(SearchJob.class);

    @Autowired
    private ISearchService searchService;
    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("查询job开始");
        Map<String,String[]> map = Token.get();
        if(map == null || map.isEmpty()) {
            return;
        }
        logger.info("查询账号总数，{}",map.size());
        for(Map.Entry<String, String[]> entry:map.entrySet()) {
            searchService.qd(entry.getKey(),entry.getValue()[0]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.error("----",e);
            }
        }

    }
}

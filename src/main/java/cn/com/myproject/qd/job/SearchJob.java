package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.TokenS;
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
        Map<String,String[]> map = TokenS.get();
        if(map == null || map.isEmpty()) {
            return;
        }
        for(String str:map.keySet()) {
            String[] strs = map.get(str);
            searchService.qd(strs[0]);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                logger.error("----",e);
            }
        }

    }
}

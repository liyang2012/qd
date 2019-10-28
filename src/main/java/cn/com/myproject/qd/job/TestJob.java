package cn.com.myproject.qd.job;

import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.service.ILoginService;
import cn.com.myproject.qd.service.IQdService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Author: x2
 * @Date: 2019/9/2 15:15
 */
public class TestJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(TestJob.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ILoginService loginService;

    @Autowired
    private IQdService qdService;
    /**
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("test.............");

    }
}

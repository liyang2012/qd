package cn.com.myproject.qd.config;

import cn.com.myproject.qd.job.LoginJob;
import cn.com.myproject.qd.job.QdJob;
import cn.com.myproject.qd.job.TestJob;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author x1
 */
@Configuration
public class QuartzConfig {

    private static final Logger logger = LoggerFactory.getLogger(QuartzConfig.class);

    @Autowired
    private Scheduler scheduler;


    @PostConstruct
    public void init() throws SchedulerException {


        logger.info("执行quartz");

        JobDetail job = JobBuilder.newJob(QdJob.class).withIdentity("q1", "d1").withDescription("抢单").build();
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* 18,19 10 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q1", "d1")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


        job = JobBuilder.newJob(LoginJob.class).withIdentity("q2", "d2").withDescription("登录").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 15 10 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q2", "d2")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }




        job = JobBuilder.newJob(TestJob.class).withIdentity("q3", "d3").withDescription("测试").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q3", "d3")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }

        job = JobBuilder.newJob(QdJob.class).withIdentity("q4", "d4").withDescription("抢单下午").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* 18,19 17 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q4", "d4")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


        job = JobBuilder.newJob(LoginJob.class).withIdentity("q5", "d5").withDescription("登录下午").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 15 17 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q5", "d5")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


    }




}

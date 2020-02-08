package cn.com.myproject.qd.config;

import cn.com.myproject.qd.constant.Ask;
import cn.com.myproject.qd.constant.Passwd;
import cn.com.myproject.qd.constant.Token;
import cn.com.myproject.qd.job.*;
import cn.com.myproject.qd.model.User;
import cn.com.myproject.qd.service.ILoginService;
import cn.com.myproject.qd.service.IUserService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author x1
 */
@Configuration
public class QuartzConfig {

    private static final Logger logger = LoggerFactory.getLogger(QuartzConfig.class);

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ILoginService loginService;

    @Autowired
    private IUserService userService;

    @PostConstruct
    public void init() throws SchedulerException {


        logger.info("执行quartz");

        JobDetail job = JobBuilder.newJob(QdJob.class).withIdentity("q1", "d1").withDescription("抢单").build();
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* 18,19,20,21 10 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q1", "d1")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


        job = JobBuilder.newJob(LoginJob.class).withIdentity("q2", "d2").withDescription("登录").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 13,16 10 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q2", "d2")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }



        job = JobBuilder.newJob(SearchJob.class).withIdentity("q-s", "d-s").withDescription("获取商品").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/3 18,19,20 10,17 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q-s", "d-s")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }



        job = JobBuilder.newJob(LoginNotJob.class).withIdentity("q2-1", "d2-1").withDescription("判断是否登录上午").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 17 10 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q2-1", "d2-1")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }

        job = JobBuilder.newJob(LoginNot3Job.class).withIdentity("q4-1", "d4-1").withDescription("判断是否登录下午").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 17 17 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q4-1", "d4-1")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


        job = JobBuilder.newJob(TestJob.class).withIdentity("q3", "d3").withDescription("测试").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q3", "d3")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }

        job = JobBuilder.newJob(QdJob.class).withIdentity("q4", "d4").withDescription("抢单下午").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* 18,19,20,21 17 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q4", "d4")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


        job = JobBuilder.newJob(Login1Job.class).withIdentity("q5", "d5").withDescription("登录下午").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 13,16 17 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q5", "d5")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


        job = JobBuilder.newJob(QdJob.class).withIdentity("q6", "d6").withDescription("抢单晚上").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* 18,19,20 20 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q6", "d6")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


        job = JobBuilder.newJob(Login2Job.class).withIdentity("q7", "d7").withDescription("登录晚上").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 15,17 20 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q7", "d7")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


        job = JobBuilder.newJob(Qd298Job.class).withIdentity("q2981", "d2981").withDescription("抢单298_1").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* 0,1,2 8 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q2981", "d2981")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }

        job = JobBuilder.newJob(Qd298Job.class).withIdentity("q2982", "d2982").withDescription("抢单298_2").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* 59 7 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q2982", "d2982")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }

        job = JobBuilder.newJob(Login298Job.class).withIdentity("q2980", "d2980").withDescription("登录298").build();
        trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0 55,57 7 * * ?")
                .withMisfireHandlingInstructionDoNothing())
                .forJob(job).withIdentity("q2980", "d2980")
                .build();

        if (scheduler.getJobDetail(job.getKey()) == null) {
            scheduler.scheduleJob(job, trigger);
        }


//
//        Passwd.goodsId = new AtomicInteger(-999);
//        Passwd.promType = new AtomicInteger(-999);
//        Passwd.specId = new AtomicInteger(-999);
//        Token.clear();
//        Ask.clear();
//        List<User> list = userService.getAll(8);
//        for(User user:list) {
//            loginService.login(user.getPhone(),user.getPasswd(),user.getNum()+"");
//        }
    }




}

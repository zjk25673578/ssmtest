package com.hanqi.util.quartz;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    private static Scheduler scheduler;

    public static void main(String[] args) {

        // 直接在xml中配置固定的Job
        // ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-quartz.xml");

        // 存入数据库
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-quartz-jdbc.xml");
        scheduler = (StdScheduler) ac.getBean("scheduler");

        startSchedule();
    }

    public static void startSchedule() {
        try {
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class)
                    // 任务执行类
                    .withIdentity("job1_1", "jGroup1")
                    // 任务名，任务组
                    .build();

            // 触发器类型
            //SimpleScheduleBuilder builder = SimpleScheduleBuilder
            // 设置执行次数
            //.repeatSecondlyForTotalCount(5);

            CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule("0/2 * * * * ?");
            // 2、创建Trigger
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1_1", "tGroup1").startNow()
                    .withSchedule(builder)
                    .build();

            // 3、创建Scheduler
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            // 4、调度执行
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}

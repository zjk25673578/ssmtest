package com.hanqi.util.quartz;

import com.hanqi.util.MyDate;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzUtil {

    public static void startOneTimeSchedule(Date date, String loop) throws Exception {
        System.err.println("=========================================任务将在" + MyDate.getTimeStr() + "开始执行===========================================");

        JobDetail jobDetail = JobBuilder.newJob(HelloWorldJob.class)
                // 任务执行类
                .withIdentity("job1_1", "jGroup1")
                // 任务名，任务组
                .build();
        //同上，触发器的也需要相应的建造器来实例化触发器，现在的 Trigger 也是接口，不能通过 new Trigger() 来实例化了
        //在得到对应的 SimpleTrigger 时，需要通过触发器建造器的 widthSchedule()方法，建造对应的触发器

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();

        if ("1".equals(loop)) {
            scheduleBuilder.repeatForever();
        }
        scheduleBuilder.withIntervalInSeconds(1);

        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                // .withIdentity(TriggerKey.triggerKey("myFirstTigger", "myFirstGroup"))
                .withSchedule(scheduleBuilder)
                .startAt(date).build();
                // .startAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.SECOND))
        // 3、创建Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.clear();
        scheduler.start();
        // 4、调度执行
        scheduler.scheduleJob(jobDetail, simpleTrigger);
    }

    public static void startSchedule(String cron) {
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

            CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(cron);
            // 2、创建Trigger
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1_1", "tGroup1").startNow()
                    .withSchedule(builder)

                    .build();

            // 3、创建Scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            // scheduler.deleteJob(JobKey.jobKey("job1_1"));
            scheduler.start();
            // 4、调度执行
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    private static String formatDateByPattern(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /***
     * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }
}

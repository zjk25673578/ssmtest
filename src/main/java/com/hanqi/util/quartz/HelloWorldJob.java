package com.hanqi.util.quartz;

import com.hanqi.util.MyDate;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloWorldJob implements Job {


    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.err.println("=========================================" + MyDate.getTimeStr() + "===========================================");
    }
}

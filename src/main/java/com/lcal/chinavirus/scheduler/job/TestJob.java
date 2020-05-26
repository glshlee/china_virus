package com.lcal.chinavirus.scheduler.job;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.lcal.chinavirus.service.SchedulerService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob extends QuartzJobBean {

    @Autowired
    private SchedulerService schedulerService;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        IntStream.range(0, 5).forEach(i -> {
            try {
                schedulerService.test(i);
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
package com.lcal.chinavirus.config;

import com.lcal.chinavirus.scheduler.job.TestJob;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzSubmitJob {
    
    @Bean(name = "testJob")
    public JobDetailFactoryBean jobTestJob() {
        return QuartzConfig.createJobDetail(TestJob.class, "Test Job");
    }

    @Bean(name = "testJobTrigger")
    public SimpleTriggerFactoryBean triggerTestJob(@Qualifier("testJob") JobDetail jobDetail) {
        return QuartzConfig.createTrigger(jobDetail, 60000, "Test Trigger");
    }
}
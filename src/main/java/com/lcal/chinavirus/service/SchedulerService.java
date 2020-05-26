package com.lcal.chinavirus.service;

import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
    
    public void test(int i) {
        System.out.println("TestJob: " + i);
    }
    
}
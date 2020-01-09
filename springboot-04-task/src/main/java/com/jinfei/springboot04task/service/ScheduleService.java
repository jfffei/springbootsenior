package com.jinfei.springboot04task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    /*
     * <ul>
     * <li>second</li>
     * <li>minute</li>
     * <li>hour</li>
     * <li>day of month</li>
     * <li>month</li>
     * <li>day of week</li>
     * </ul>
     *
     * <p>For example, {@code "0 * * * * MON-FRI"} means once per minute on weekdays
     * (at the top of the minute - the 0th second).
     * */
//    @Scheduled(cron = "0 * * * * MON-TUE")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-TUE")
//    @Scheduled(cron = "0-4 * * * * MON-TUE")
    @Scheduled(cron = "0/4 * * * * MON-TUE")    //每4秒执行一次
    public void hello() {
        System.out.println("hello....");
    }
}

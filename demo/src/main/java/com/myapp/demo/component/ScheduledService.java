package com.myapp.demo.component;

import com.myapp.demo.service.IStepService;
import com.myapp.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 定时事务类
 */
@Component
public class ScheduledService {

    @Autowired
    private IStepService stepService;

    @Autowired
    private IUserService userService;

    /**
     * 每隔5秒
     */
//    @Scheduled(cron = "0/5 * * * * *")
//    public void scheduled() {
//        System.out.println(("=====>>>>>使用cron  {}"+ new Date()));
//
//    }


    /**
     * 每天晚上23:50分清零当天步数并增加至其他步数中
     */
    @Scheduled(cron= "0 50 23 * * *")
    public void scheduleDay(){
        //
    }

    /**
     * 每周日晚23:50清零本周步数
     */
    @Scheduled(cron="0 55 23 ? * SUN")
    public void scheduleWeek(){
        //
    }

    /**
     *每月第一天凌晨事务
     */
    @Scheduled(cron="0 1 0 1 * ?")
    public void scheduleMonth(){
        //
    }

    /**
     * 每隔3个月的第一天的凌晨
     */
    @Scheduled(cron="0 2 0 1 1/3 ?")
    public void scheduleSeason(){
        //
    }
}

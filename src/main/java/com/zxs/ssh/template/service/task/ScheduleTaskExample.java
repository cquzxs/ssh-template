package com.zxs.ssh.template.service.task;

import com.zxs.ssh.template.service.user.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Project Name:ssh-template
 * File Name:ScheduleTaskExample
 * Package Name:com.zxs.ssh.template.service.task
 * Date:2019/2/18
 * Author:zengxueshan
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */

@Component("scheduleTaskExample")
@EnableScheduling
public class ScheduleTaskExample {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    //@Scheduled(cron = "0 * 9 ? * *")    //9点的每分钟执行一次  cron表达式： 秒 分钟 小时 日期 月份 星期
    public void timeTask(){
        logger.info(Timestamp.from(Instant.now()).toString());
    }
}

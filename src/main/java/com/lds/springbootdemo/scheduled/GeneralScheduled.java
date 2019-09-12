package com.lds.springbootdemo.scheduled;

import com.lds.springbootdemo.util.General;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class GeneralScheduled {

    private static final Logger logger = LoggerFactory.getLogger(GeneralScheduled.class);

    /**
     * 定时器  每秒同步一次
     *
     */
    @Scheduled(cron="0/1 * * * * ? ")
    public void index() {
        System.out.println("定时任务-time："+ General.getTime());
    }
}

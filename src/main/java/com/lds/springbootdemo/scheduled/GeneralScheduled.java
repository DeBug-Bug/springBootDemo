package com.lds.springbootdemo.scheduled;

import com.lds.springbootdemo.util.General;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

/**
 * @Program:
 * @Description:  GeneralScheduled.java：
 * @Author: lidongsheng
 * @CreateData:
 * @UpdateAuthor:
 * @UpdateData:
 * @UpdateContent:
 * @Version: 1.0
 * @Email: lidongshenglife@163.com
 * @Blog: www.b0c0.com
 */
@Component
public class GeneralScheduled {

    private static final Logger logger = LoggerFactory.getLogger(GeneralScheduled.class);

    /**
     * 定时器  每秒同步一次
     */
    @Scheduled(cron = "0/1 * * * * ? ")
    public void index1() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.error("定时任务1-time：" + General.getTime());
    }

    /**
     * 定时器  每秒同步一次
     */
    @Scheduled(cron = "0/4 * * * * ? ")
    public void index2() {
        logger.error("定时任务2-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index3() {
        logger.error("定时任务3-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index4() {
        logger.error("定时任务4-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index5() {
        logger.error("定时任务5-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index6() {
        logger.error("定时任务6-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index7() {
        logger.error("定时任务7-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index8() {
        logger.error("定时任务8-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index9() {
        logger.error("定时任务9-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index10() {
        logger.error("定时任务10-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index11() {
        logger.error("定时任务11-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index12() {
        logger.error("定时任务12-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index13() {
        logger.error("定时任务13-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index14() {
        logger.error("定时任务14-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index15() {
        logger.error("定时任务15-time：" + General.getTime());
    }

    @Scheduled(cron = "0/1 * * * * ? ")
    public void index16() {
        logger.error("定时任务16-time：" + General.getTime());
    }

    @Scheduled(cron = "0/2 * * * * ? ")
    public void index17() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.error("定时任务17-time：" + General.getTime());
    }
    @Scheduled(cron = "0/1 * * * * ? ")
    public void index18() {
        logger.error("定时任务18-time：" + General.getTime());
    }
    @Scheduled(cron = "0/1 * * * * ? ")
    public void index19() {
        logger.error("定时任务19-time：" + General.getTime());
    }

    /**
     * 开启定时器多线程支持
     * @return
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        return scheduler;
    }
}

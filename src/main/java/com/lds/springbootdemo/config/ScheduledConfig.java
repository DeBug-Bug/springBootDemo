//package com.lds.springbootdemo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.TaskScheduler;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.Executors;
//
///**
// * @program: springbootdemo
// * @description:
// * @author: lidongsheng
// * @createData: 2019-11-14 17:09
// * @updateAuthor: lidongsheng
// * @updateData: 2019-11-14 17:09
// * @updateContent:
// * @Version: 1.0.0
// * @email: lidongshenglife@163.com
// * @blog: www.b0c0.com
// */
//
//@Configuration
//public class ScheduledConfig implements SchedulingConfigurer {
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.setScheduler(setTaskExecutors());
//    }
//
//    @Bean(destroyMethod="shutdown")
//    public Executor setTaskExecutors(){
//        // 20个线程来处理。
//        return Executors.newScheduledThreadPool(10);
//    }
//}

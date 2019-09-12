package com.lds.springbootdemo.factory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * 统一创建线程池，管理
 */
@Configuration
@EnableAsync
public class ThreadPoolFactory {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolFactory.class);

    private static final ThreadFactory NAMED_MESSAGE_PUSH = new ThreadFactoryBuilder().setNameFormat("private-pool-%d").build();
    //核心线程池大小
    private static final int CORE_POOL_SIZE = 2;
    //最大线程池大小
    private static final int MAX_POOL_SIZE = 20;
    //线程任务队列大小
    private static final int QUEUE_CAPACITY = 1024;
    //空闲线程的存活时间.默认情况下核心线程不会退出
    private static final int KEEP_ALIVE_TIME = 20;
    //通用线程池
    private static final String NAMED_GENERAL = "thsLockManager-pool-general-";
    /**
     * unit：时间单位
     * workQueue：线程等待队列  四种队列 1.ArrayBlockingQueue：有界队列，2.SynchronousQueue：同步队列，3.LinkedBlockingQueue：无界队列，4.DelayQueue：延时阻塞队列
     * threadFactory：线程创建工厂
     * handler：拒绝策略 四种策略 1.ThreadPoolExecutor.AbortPolicy()：2.ThreadPoolExecutor.CallerRunsPolicy()：3.ThreadPoolExecutor.DiscardOldestPolicy()：4.ThreadPoolExecutor.DiscardPolicy()
     */
    private static final ExecutorService EXECUTOR_MESSAGE_PUSH = new ThreadPoolExecutor(
            CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(QUEUE_CAPACITY), NAMED_MESSAGE_PUSH, new ThreadPoolExecutor.AbortPolicy());


    public static ExecutorService getExecutorMessagePush() {
        return EXECUTOR_MESSAGE_PUSH;
    }

    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(CORE_POOL_SIZE);
        // 配置最大线程数
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        // 配置队列大小
        executor.setQueueCapacity(QUEUE_CAPACITY);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(NAMED_GENERAL);
        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行,由于可能为关键任务尽量保证让其执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 执行初始化
        executor.initialize();
        return executor;
    }
}

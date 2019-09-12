package com.lds.springbootdemo.factory;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @Program:
 * @Description:
 * @Author: lidongsheng
 * @CreateData: 18:17
 * @UpdateAuthor:
 * @UpdateData:
 * @UpdateContent:
 * @Version: 1.0
 * @Email: lidongshenglife@163.com
 * @Blog: www.b0c0.com
 */
@Component
public class TaskTest {
    public static Random random =new Random();
    @Async("asyncServiceExecutor")
    public Future<String> doTaskOne() throws Exception {
        //System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        //Thread.sleep(random.nextInt(3000));
        long end = System.currentTimeMillis();
        //System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }
    @Async("asyncServiceExecutor")
    public Future<String> doTaskTwo() throws Exception {
        //System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        //Thread.sleep(random.nextInt(3000));
        long end = System.currentTimeMillis();
        //System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }
    @Async("asyncServiceExecutor")
    public Future<String> doTaskThree() throws Exception {
        //System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        //Thread.sleep(random.nextInt(3000));
        long end = System.currentTimeMillis();
        //System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }
    public void te() throws Exception {
        ThreadPoolTaskExecutor t1=new ThreadPoolTaskExecutor();
        ThreadPoolTaskExecutor t2=new ThreadPoolTaskExecutor();
        ThreadPoolTaskExecutor t3=new ThreadPoolTaskExecutor();
    }
}

package com.lds.springbootdemo.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.Future;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolFactoryTest {

    @Autowired
    private TaskTest taskTest;
    @Autowired
    private test test;
    @Test
    public void getExecutorMessagePush() {

        try {

            taskTest.te();
            taskTest.te();
            taskTest.te();
            Thread.sleep(500000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void asyncServiceExecutor() {
        try {
            long start = System.currentTimeMillis();
            for(int i=0;i<1000;i++){
                Future<String> task1 = taskTest.doTaskOne();
                Future<String> task2 = taskTest.doTaskTwo();
                Future<String> task3 = taskTest.doTaskThree();
                //test.doTaskOne();
                //test.doTaskTwo();
                //test.doTaskThree();
            }
            /*
            while(true) {
                if (task1.isDone() && task2.isDone() && task3.isDone()) {
                    long end = System.currentTimeMillis();
                    System.out.println("完成任务，总耗时：" + (end - start) + "毫秒");
                    break;
                }
            }
            */
            Thread.sleep(6000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
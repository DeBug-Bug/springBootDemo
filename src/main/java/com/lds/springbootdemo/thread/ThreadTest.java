package com.lds.springbootdemo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @program: springbootdemo
 * @description: 线程测试类
 * @author: lidongsheng
 * @createData: 2019-11-14 15:21
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-14 15:21
 * @updateContent:
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 */

public class ThreadTest {

    private Boolean synLock = new Boolean(false);
    public void test(ThreadMain _this) {
        System.out.println("test");
        run(_this);
    }
    synchronized public void test1(ThreadMain _this) {
        System.out.println("test1");
        run(_this);
    }

    synchronized public void test2(ThreadMain _this) {
        System.out.println("test2");
        run(_this);
    }

    public void testBlockString(ThreadMain _this) {
        synchronized (String.class) {
            System.out.println("testBlockString");
            run(_this);
        }
    }

    public void testBlockDouble(ThreadMain _this) {
        System.out.println("testBlockDouble ber");
        synchronized (Double.class) {
            System.out.println("testBlockDouble");
            run(_this);
        }
    }

    public void testBlockComm1(ThreadMain _this) {
        System.out.println("testBlockComm1 ber");
        synchronized (synLock) {
            System.out.println("testBlockComm1");
            run(_this);
        }
    }
    public void testBlockComm2(ThreadMain _this) {
        System.out.println("testBlockComm2 ber");
        synchronized (synLock) {
            System.out.println("testBlockComm2");
            run(_this);
        }
    }
    public void run(ThreadMain _this){
        while (true) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toSeconds(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread name = "+Thread.currentThread().getName()+" methodName = "+((ThreadMain)_this).methodName+" 该线程不会结束!");
        }
    }
}

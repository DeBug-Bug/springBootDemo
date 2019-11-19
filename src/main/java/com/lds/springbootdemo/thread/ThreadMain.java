package com.lds.springbootdemo.thread;

/**
 * @program: springbootdemo
 * @description:
 * @author: lidongsheng
 * @createData: 2019-11-14 15:40
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-14 15:40
 * @updateContent:
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 */

public class ThreadMain extends Thread{
        //由jvm保证ThreadTest中syn是单例,保证它是个临界资源
        private static ThreadTest syn = new ThreadTest();
        String methodName = "";
        public ThreadMain(String methodName){
            this.methodName = methodName;
        }
        @Override
        public void run() {
            switch (methodName) {
                case "test1":
                    syn.test1(this);
                    break;
                case "test2":
                    syn.test2(this);
                    break;
                case "test":
                    syn.test(this);
                    break;
                case "testBlockString":
                    syn.testBlockString(this);
                    break;
                case "testBlockDouble":
                    syn.testBlockDouble(this);
                    break;
                case "testBlockComm1":
                    syn.testBlockComm1(this);
                    break;
                case "testBlockComm2":
                    syn.testBlockComm2(this);
                    break;
                default:
                    break;
            }
        }
    public static void main(String[] args) {
        ThreadMain tt1 = new ThreadMain("testBlockComm1");
        ThreadMain tt2 = new ThreadMain("testBlockComm2");
        //开启线程
        tt1.start();
        tt2.start();
    }
}

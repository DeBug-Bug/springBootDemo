package com.lds.springbootdemo.test.designPatterns.AbstractFactory;

/**
 * @program: springbootdemo
 * @description: 抽象工厂模式测试类
 * @author: lidongsheng
 * @createData: 2019-11-19 17:15
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-19 17:15
 * @updateContent: 抽象工厂模式测试类
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class TestMain {
    public static void main(String[] args) {
        HPFactory hpFactory = new HPFactory();
        Mouse HPMouse = hpFactory.creatMouse();
        Keybo HPkeybo = hpFactory.creatKeybo();
        HPMouse.say();
        HPkeybo.say();
        DellFactory dellFactory = new DellFactory();
        Mouse DellMouse = dellFactory.creatMouse();
        Keybo DellKeybo = dellFactory.creatKeybo();
        DellMouse.say();
        DellKeybo.say();
    }
}

package com.lds.springbootdemo.test.designPatterns.AbstractFactory;

/**
 * @program: springbootdemo
 * @description: 抽象工厂模式测试类
 *
 * 抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 何时使用：系统的产品（A）有多于一个的产品族（B），而系统只消费其中某一族的产品（C）。
 *
 * 本例中：
 * 超级工厂(A)；pc基础厂商
 * 其他工厂(B)：Dell（戴尔）、HP（惠普）
 * 戴尔会生产戴尔的电脑产品、惠普会生产惠普的电脑产品(C)。
 *
 * 电脑看为一个大的系统(A)，而有很多厂商（B）生产自己品牌的产品(C).
 * 就像生活中的我们去淘宝某品牌的旗舰店去买东西，该店肯定是只售卖本品牌的产品，而我们买到的也肯定是该品牌的产品，不能买到其他品牌的产品。
 *
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

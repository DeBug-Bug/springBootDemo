package com.lds.springbootdemo.test.designPatterns.AbstractFactory;

/**
 * @program: springbootdemo
 * @description: 戴尔键盘
 * @author: lidongsheng
 * @createData: 2019-11-19 16:55
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-19 16:55
 * @updateContent: 戴尔键盘
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class DellKeybo implements Keybo {
    @Override
    public void say() {
        System.out.println("DellKeybo");
    }
}

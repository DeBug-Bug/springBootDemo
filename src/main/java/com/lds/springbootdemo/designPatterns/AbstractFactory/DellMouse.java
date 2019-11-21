package com.lds.springbootdemo.designPatterns.AbstractFactory;

/**
 * @program: springbootdemo
 * @description: 戴尔鼠标
 * @author: lidongsheng
 * @createData: 2019-11-19 16:54
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-19 16:54
 * @updateContent: 戴尔鼠标
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class DellMouse implements Mouse {

    @Override
    public void say() {
        System.out.println("DellMouse");
    }
}

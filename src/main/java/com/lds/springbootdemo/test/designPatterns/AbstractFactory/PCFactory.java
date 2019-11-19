package com.lds.springbootdemo.test.designPatterns.AbstractFactory;

/**
 * @program: springbootdemo
 * @description: pc工厂类 生产键盘和鼠标
 * @author: lidongsheng
 * @createData: 2019-11-19 16:48
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-19 16:48
 * @updateContent: pc工厂类
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public abstract class PCFactory {
    /**
     * 创建一个鼠标
     * @return
     */
    public abstract Mouse creatMouse();

    /**
     * 创建一个键盘
     * @return
     */
    public abstract Keybo creatKeybo();
}

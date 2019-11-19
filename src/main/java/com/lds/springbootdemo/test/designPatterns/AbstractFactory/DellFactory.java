package com.lds.springbootdemo.test.designPatterns.AbstractFactory;

/**
 * @program: springbootdemo
 * @description: 戴尔工厂
 * @author: lidongsheng
 * @createData: 2019-11-19 17:14
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-19 17:14
 * @updateContent: 戴尔工厂
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class DellFactory extends PCFactory{
    @Override
    public Mouse creatMouse() {
        return new DellMouse();
    }

    @Override
    public Keybo creatKeybo() {
        return new DellKeybo();
    }
}

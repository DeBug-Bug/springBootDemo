package com.lds.springbootdemo.designPatterns.AbstractFactory;

/**
 * @program: springbootdemo
 * @description: 惠普工厂
 * @author: lidongsheng
 * @createData: 2019-11-19 16:57
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-19 16:57
 * @updateContent: 惠普工厂
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class HPFactory extends PCFactory{

    @Override
    public Mouse creatMouse() {
        return new HPMouse();
    }

    @Override
    public Keybo creatKeybo() {
        return new HPKeybo();
    }

}

package com.lds.springbootdemo.test.designPatterns.Bridge;

/**
 * @program: springbootdemo
 * @description:
 * @author: lidongsheng
 * @createData: 2019-11-20 18:36
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-20 18:36
 * @updateContent:
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class CarDF extends AbstractCar {
    @Override
    public void run(int speed) {
        System.out.printf("CarDF init "+displacement.dispose()+transmission.dispose()+"--run: speend:"+speed);
    }
}

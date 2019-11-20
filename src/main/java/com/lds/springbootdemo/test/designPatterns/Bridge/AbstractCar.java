package com.lds.springbootdemo.test.designPatterns.Bridge;

/**
 * @program: springbootdemo
 * @description:
 * @author: lidongsheng
 * @createData: 2019-11-20 17:58
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-20 17:58
 * @updateContent:
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public abstract class AbstractCar {

    public Transmission transmission;
    public Displacement displacement;

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setDisplacement(Displacement displacement) {
        this.displacement = displacement;
    }

    public abstract void run(int speed);

}

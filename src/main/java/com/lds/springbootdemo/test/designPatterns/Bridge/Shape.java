package com.lds.springbootdemo.test.designPatterns.Bridge;

/**
 * @program: springbootdemo
 * @description: 画形状
 * @author: lidongsheng
 * @createData: 2019-11-18 19:37
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-18 19:37
 * @updateContent: 画形状
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public abstract class Shape {

    public Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

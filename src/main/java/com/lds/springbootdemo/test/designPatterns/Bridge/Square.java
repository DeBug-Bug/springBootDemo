package com.lds.springbootdemo.test.designPatterns.Bridge;

import com.lds.springbootdemo.test.designPatterns.Bridge.Shape;

/**
 * @program: springbootdemo
 * @description: 正方形
 * @author: lidongsheng
 * @createData: 2019-11-18 19:41
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-18 19:41
 * @updateContent: 正方形
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class Square extends Shape {

    @Override
    public void draw() {
        color.bepaint("正方形");
    }
}

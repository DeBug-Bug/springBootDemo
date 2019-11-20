package com.lds.springbootdemo.test.designPatterns.Bridge;

/**
 * @program: springbootdemo
 * @description:
 * @author: lidongsheng
 * @createData: 2019-11-20 18:28
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-20 18:28
 * @updateContent:
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class DisplacementBig extends Displacement {
    @Override
    public String dispose() {
        //业务处理
        return "大排量";
    }
}

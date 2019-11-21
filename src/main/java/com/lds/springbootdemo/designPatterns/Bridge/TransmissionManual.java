package com.lds.springbootdemo.designPatterns.Bridge;

/**
 * @program: springbootdemo
 * @description:
 * @author: lidongsheng
 * @createData: 2019-11-20 18:31
 * @updateAuthor: lidongsheng
 * @updateData: 2019-11-20 18:31
 * @updateContent:
 * @Version: 1.0.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 * ************************************************
 * Copyright @ 李东升 2019. All rights reserved
 * ************************************************
 */

public class TransmissionManual extends Transmission {
    @Override
    public String dispose() {
        //业务处理
        return "手动挡";
    }
}

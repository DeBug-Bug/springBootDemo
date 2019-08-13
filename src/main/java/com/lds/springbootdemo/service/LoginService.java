package com.lds.springbootdemo.service;


/**
 * @program: springbootdemo
 * @description:
 * @author:
 * @createData:
 * @updateAuthor:
 * @updateData:
 * @updateContent:
 * @Version: 1.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 */


public interface LoginService {
    /**
     * 登录验证Service
     * @return
     */
    boolean loginValidate(String account, String password);
}

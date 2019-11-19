package com.lds.springbootdemo.service.impl;

import com.lds.springbootdemo.dao.DaoSupport;
import com.lds.springbootdemo.domain.sbd_user;
import com.lds.springbootdemo.service.LoginService;
import com.lds.springbootdemo.redis.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springbootdemo
 * @description: 登录验证Service
 * @author:
 * @createData:
 * @updateAuthor:
 * @updateData:
 * @updateContent:
 * @Version: 1.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 */
@Service
public class LoginServiceImpl implements LoginService {

//    @Autowired
//    private sbd_userMapper userMapper;

    @Autowired
    private DaoSupport dao;

    @Autowired
    private RedisCacheService redisCacheService;

    @Override
    //@AnnotationAOP(name = "loginValidate")
    public boolean loginValidate(String account,String password) {
        boolean retu=false;
        sbd_user user= null;
        try {
            user = (sbd_user) dao.selectForOne("sbd_userMapper.selectByAccount",account);
            //user = userMapper.selectByAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user!=null&&password.equals(user.getPassword())){
            retu=true;
        }
        return retu;
    }
}

package com.lds.springbootdemo.service.login_register;

import com.lds.springbootdemo.aop.AnnotationAOP;
import com.lds.springbootdemo.dao.DaoSupport;
import com.lds.springbootdemo.domain.sbd_user;
import com.lds.springbootdemo.mapper.sbd_userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class LoginServiceImpl implements LoginService {

    //@Autowired
    //private sbd_userMapper userMapper;
    @Autowired
    private DaoSupport dao;
    /**
     * 登录验证Service
     * @return
     */
    @Override
    //@AnnotationAOP(name = "loginValidate")
    public boolean loginValidate(String account,String password) {
        boolean retu=false;
        //sbd_user em=userMapper.selectByAccount(account);
        sbd_user user= null;
        try {
            user = (sbd_user) dao.selectForOne("sbd_userMapper.selectByAccount",account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user!=null&&password.equals(user.getPassword())){
            retu=true;
        }
        return retu;
    }
}

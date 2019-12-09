package com.lds.springbootdemo.controller.login_register;

import com.lds.springbootdemo.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
/*
@RestController是一个组合注解，用于标注控制层组件(如struts中的action)
@RestController = @Controller + @ResponseBody
@RestController注解直接将返回的对象输出到客户端
如果返回字符串，直接返回
如果返回不是字符串，默认使用Jackson将对象序列化成JSON字符串后输出
这个不会返回视图
 */
@RestController
@RequestMapping("/login")
@Api(tags = "登录接口")
public class LoginController {
    //自动注入bean
    @Autowired
    private LoginService loginService;
    @GetMapping(value = "/loginValidate")
    @ApiOperation(value="登录验证")
    public String loginValidate(String account,String password) {
        boolean validate=loginService.loginValidate(account, password);
        if(validate){
            return "200";
        }else{
            return "400";
        }
    }
    /*
    也可以使用这种方法获得前台传的值
    @RequestMapping(value = "/loginValidate")
    public String loginValidate(HttpServletRequest request) {
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        boolean validate=loginService.loginValidate(account, password);
        if(validate){
            return "200";
        }else{
            return "400";
        }
    }
     */

}

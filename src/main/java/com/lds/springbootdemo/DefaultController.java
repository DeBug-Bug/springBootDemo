package com.lds.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springBootDemo
 * @description: 项目默认的Controller
 * @author:
 * @createData:
 * @updateAuthor:
 * @updateData:
 * @updateContent: 项目默认的Controller
 * @Version: 1.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 */

@Controller
public class DefaultController {
    @RequestMapping(value = "/")
    public String index(Model model) {

        return "forward:view/login_register/login.html";
    }
}

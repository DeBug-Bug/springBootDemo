package com.lds.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springBootDemo
 * @description: HelloController测试
 * @author: lidongsheng
 * @createData:
 * @updateAuthor: lidongsheng
 * @updateData:
 * @updateContent: HelloController测试
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
@RestController不会返回视图，前后端全部分离时可以用这个。
所以我们想返回视图的话还是用@Controller就行。
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping(value = "/sayHello")
    public String sayHello(Model model) {
        model.addAttribute("data", "LDS的第一个spring boot项目说了helloWord！");
        //返回的视图名称
        return "SpringBootSayHelloWord";
    }
}
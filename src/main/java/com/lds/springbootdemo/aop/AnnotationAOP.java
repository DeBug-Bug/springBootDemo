package com.lds.springbootdemo.aop;
import java.lang.annotation.*;

/**
 * @program: springBootDemo
 * @description: 使用AOP注解拦截
 * @author:
 * @createData:
 * @updateAuthor:
 * @updateData:
 * @updateContent: 使用AOP注解拦截
 * @Version: 1.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 */
    /**
     * 定义了该注解可以出现在哪里。常用的：
     * TYPE：类, 接口 (包括注释类型), 或 枚举 声明
     *     FIELD：字段声明（包括枚举常量）
     *     METHOD：方法声明
     */
    @Target(ElementType.METHOD)
    /**
     * Reteniton的作用是定义被它所注解的注解保留多久
     * SOURCE
     * 被编译器忽略。
     * CLASS
     * 注解将会被保留在Class文件中，但在运行时并不会被VM保留。
     * 这是默认行为，所有没有用Retention注解的注解，都会采用这种策略。
     * RUNTIME
     * 保留至运行时。所以我们可以通过反射去获取注解信息。
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface AnnotationAOP {
        String name();
    }

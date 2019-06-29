package com.lds.springbootdemo.aop.aspect;

import com.lds.springbootdemo.aop.AnnotationAOP;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @program: springBootDemo
 * @description: AOP拦截切面类
 * @author: lidongsheng
 * @createData:
 * @updateAuthor: lidongsheng
 * @updateData:
 * @updateContent: AOP拦截切面类
 * @Version: 1.0
 * @email: lidongshenglife@163.com
 * @blog: www.b0c0.com
 */
@Aspect
@Component
public class TestAspect {


//    /**
//     * 注解是拦截定义切入点，切入点为com.example.aop下的所有函数
//     */
//    @Pointcut("@annotation(com.lds.springbootdemo.aop.AnnotationAOP)")
//    public void annotationPoinCut(){
//    }
//
//    /**
//     * 前置通知，方法调用前被调用 执行顺序：1
//     * @param joinPoint/null
//     */
//    @Before("annotationPoinCut()")
//    public void before(JoinPoint joinPoint){
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        AnnotationAOP action = method.getAnnotation(AnnotationAOP.class);
//        Parameter[] ps =method.getParameters();
//        System.out.println("注解式拦截 该方法执行之前：第一个参数:"+ps[0].toString()+"    自定义注解的name值:"+action.name());
//    }
//
//    /**
//     * 后置通知（目标方法只要执行完了就会执行后置通知方法,不管是否出现异常） 执行顺序：2
//     * @param joinPoint
//     */
//    @After("execution(* com.lds.springbootdemo.service.login_register.LoginServiceImpl.loginValidate(..))")
//    public void after(JoinPoint joinPoint){
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        AnnotationAOP action = method.getAnnotation(AnnotationAOP.class);
//        System.out.println("方法规则式拦截 该方法执行之后："+method.getName());
//    }
//    /**
//     * 后置返回通知  在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理） 执行顺序：3
//     * 这里需要注意的是:
//     *      如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
//     *       returning：限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，
//     *       对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
//     * @param joinPoint
//     * @param keys
//     */
//    @AfterReturning(value = "annotationPoinCut()",returning = "keys")
//    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object keys){
//        System.out.println("注解式拦截 该方法执行返回结果： "+keys);
//    }

    /**
     * 环绕通知 在目标方法完成前后做增强处理，也是最重要的通知类型，像事务,日志等都是环绕通知。
     * @param joinPoint
     * @return
     */
    //@Around("annotationPoinCut()") ProceedingJoinPoint是子类，只能用在@Around中
    @Around("execution(* com.lds.springbootdemo.service.login_register.LoginServiceImpl.loginValidate(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) {
        //.这里获取到所有的参数值的数组
        Object[] parameterValues = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        //.通过这获取到方法的所有参数名称的字符串数组
        String[] parameterNames = methodSignature.getParameterNames();
        //得到执行方法的方法名
        String methodName=methodSignature.getMethod().getName();
        System.out.println("环绕拦截前");
        Object obj = null;
        try {
            obj = joinPoint.proceed();//调用执行目标方法并得到执行方法的返回值
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕拦截执行方法出错");
        }
        System.out.println("环绕拦截后");
        return obj;
    }


}

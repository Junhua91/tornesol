package com.junhua.tornesol.util.spring.spring_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;


@Aspect
public class LogAspects {

////    通知方法：
    ////    前置通知(@Before):在目标方法前调用
    //      后置通知(@After)：
    //      返回通知(@AfterReturning)
    //      异常通知(@AfterThrowing)
    //      环绕通知(@Around)

    //抽取公共切入点表达式
    @Pointcut("execution(int com.junhua.tornesol.util.spring.spring_aop.MathCalculator.div(int,int))")
    public void pointCut() {

    }

    @Before("com.junhua.tornesol.util.spring.spring_aop.LogAspects.pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " 除法运行,参数是：" + Arrays.asList(joinPoint.getArgs()));
    }

    @After("com.junhua.tornesol.util.spring.spring_aop.LogAspects.pointCut()")
    public void logEnd() {
        System.out.println("除法结束");
    }


    @AfterReturning(value = "com.junhua.tornesol.util.spring.spring_aop.LogAspects.pointCut())", returning = "result")
    public void logReturn2(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "除法返回" + result);
    }

    @AfterThrowing(value = "com.junhua.tornesol.util.spring.spring_aop.LogAspects.pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("除法异常");
    }
}

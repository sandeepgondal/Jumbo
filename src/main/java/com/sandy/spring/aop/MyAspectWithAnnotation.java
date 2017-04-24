package com.sandy.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by gondals on 31/08/16.
 */

@Aspect
@Component
public class MyAspectWithAnnotation {

    @Before("execution(* com.sandy.spring.aop.MyAOPBean.myMethod())")
    public void myBeforeAdvice() {
        System.out.println("\n\n\nLogging Before : This is a advice from Aspect");
    }

}

package com.sandy.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by gondals on 31/08/16.
 */

@Component
public class MyAspectWithConfiguration {

    public void myBeforeAdvice() {
        System.out.println("\n\n\nLogging Before : This is a advice from Aspect");
    }

    public void myAfterAdvice() {
        System.out.println("Logging After : This is a advice from Aspect");
    }

}

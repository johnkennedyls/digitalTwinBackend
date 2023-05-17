package com.icesi.edu.co.pdg.dashboard.logs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.icesi.edu.co.pdg.dashboard.controller..*.*(..))")
    public void beforeControllerMethod() {
        System.out.println("A controller method is about to be called!");
    }

}

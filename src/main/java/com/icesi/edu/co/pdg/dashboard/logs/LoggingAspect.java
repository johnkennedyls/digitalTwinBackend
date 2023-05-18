package com.icesi.edu.co.pdg.dashboard.logs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icesi.edu.co.pdg.dashboard.services.interfaces.LogDashboardService;

@Aspect
@Component
public class LoggingAspect {

}

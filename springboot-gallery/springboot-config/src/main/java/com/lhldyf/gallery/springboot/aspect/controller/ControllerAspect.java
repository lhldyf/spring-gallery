package com.lhldyf.gallery.springboot.aspect.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller的切面
 * @author lhldyf
 * @date 2020-02-21 11:32
 */
@Aspect
@Component
public class ControllerAspect {

    @Pointcut("@annotation(com.lhldyf.gallery.springboot.aspect.controller.ControllerAspectPoint)")
    public void workspace() {
        System.out.println("point cut log");
    }

    @Before(value = "workspace()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("do before");
        TestCondition condition = (TestCondition) joinPoint.getArgs()[0];
        System.out.println("id: " + condition.getId());
        condition.setId("4");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        System.out.println("url: " + request.getRequestURI());
        System.out.println(
                "class.method: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature()
                                                                                                    .getName());
    }

    @After("workspace()")
    public void doAfter() {
        System.out.println("do after");
    }

    @AfterReturning(returning = "result", pointcut = "workspace()")
    public void doAfterReturning(Object result) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        System.out.println("url: " + request.getRequestURI());

        TestVO testVO = (TestVO) result;
        // testVO.setId("2");
    }
}

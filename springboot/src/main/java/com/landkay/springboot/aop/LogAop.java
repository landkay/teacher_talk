package com.landkay.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Component
/**
 * Description 打印日志
 * @author landkay
 * @Date 11:42 2018/8/3
 * @return
 **/
public class LogAop {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Pointcut("execution(public * com.landkay.springboot..*.*(..))")
    @Pointcut("execution(public * com.landkay.springboot.controller..*.*(..))")
    public void webLog() {
    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {

        // 接收到请求，记录请求内容
        logger.info("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null != attributes) {
            HttpServletRequest request = attributes.getRequest();

            // 记录下请求内容
            logger.info("URL : " + request.getRequestURL().toString());
            logger.info("HTTP_METHOD : " + request.getMethod());
            logger.info("IP : " + request.getRemoteAddr());
            logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature
                    ().getName());

            //获取所有参数方法一：
            Enumeration<String> enu = request.getParameterNames();
            while (enu.hasMoreElements()) {
                String paraName = enu.nextElement();
                System.out.println(paraName + ": " + request.getParameter(paraName));
            }
        }
    }

    @AfterReturning(pointcut = "webLog()", returning = "object")
    public void doAfterReturning(JoinPoint joinPoint, Object object) {
        // 处理完请求，返回内容
        logger.info("WebLogAspect.doAfterReturning()");
        logger.info("*********打印请求参数***** RequestParams : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("*********打印结果信息*****  result:"+ object);
    }
}

/* @()controllerAspect.java
 *
 * (c) COPYRIGHT 2009-2013 Bee INC. All rights reserved.
 * Bee CONFIDENTIAL PROPRIETARY
 * Bee Advanced Technology and Software Operations
 *
 * REVISION HISTORY:
 * Author             Date                   Brief Description
 * -----------------  ----------     ---------------------------------------
 * Linfeng            下午3:49:02                init version
 * 
 */
package com.bee.myApp.blog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * CLASS: Describe class, extends and implements relationships to other classes.
 * 
 * RESPONSIBILITIES: High level list of things that the class does -)
 * 
 * COLABORATORS: List of descriptions of relationships with other classes, i.e.
 * uses, contains, creates, calls... -) class relationship -) class relationship
 * 
 * USAGE: Description of typical usage of class. Include code samples.
 * 
 * 
 **/
@Component
@Aspect
public class ControllerAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

	@Around(value = "execution(* com.bee.myApp.blog.web.controller.*.*(..))")
	public Object processLog(ProceedingJoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		StringBuilder url = new StringBuilder();
		url.append(request.getRequestURI());
		String queryString = request.getQueryString();
		if(queryString != null){
			url.append("?").append(queryString);
		}
		LOGGER.info("传入的RUL:{}",url.toString());

		Object result = joinPoint.proceed();
		LOGGER.info("返回的结果:{}",result);
		return result;

//		Object rvt = joinPoint.proceed();
//		Object[] args = joinPoint.getArgs();
//		StringBuilder s = new StringBuilder();
//		if (args != null) {
//			if (args.length > 1 && args[1] instanceof HttpServletRequest) {
//				HttpServletRequest h = (HttpServletRequest) args[1];
//				s.append(h.getRequestURI()).append("?").append(h.getQueryString()).append(" ").append(args[0]);
//				s.append(" FRM:").append(h.getRemoteAddr());
//			} else if (args.length > 0 && args[0] instanceof HttpServletRequest) {
//				HttpServletRequest h = (HttpServletRequest) args[0];
//				s.append(h.getRequestURI()).append("?").append(h.getQueryString()).append(" FRM:").append(h.getRemoteAddr());
//			}
//		}
//		System.out.println(s.toString());
//
//		return rvt;
	}

	// 后置最终通知
	public void afterFinallyAdvice() {
		System.out.println("===========after finally advice");
	}
}

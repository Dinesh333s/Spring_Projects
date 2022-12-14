package com.floppy.springmvcboot;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspects {

	public static final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(LoggingAspects.class);

	@Before("execution(public * com.floppy.springmvcboot.Aliencontroller.getalien())")
	public void Beforelog() {
		LOGGER.info("get Alien Executed from Aspect Class");
	}

	@AfterReturning("execution(public * com.floppy.springmvcboot.Aliencontroller.getalien())")
	public void Afterlog() {
		LOGGER.info("afterReturning success.. get Alien Executed ");
	}

	@AfterThrowing("execution(public * com.floppy.springmvcboot.Aliencontroller.getalien())")
	public void Logexception() {
		LOGGER.info("afterThrowing get Alien found an Exception ");
	}

//	@After("execution(public * com.floppy.springmvcboot.Aliencontroller.getalien())")
//	public void Afterlog() {
//		LOGGER.info("after finally get Alien Executed ");
//	}

}

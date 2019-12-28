package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpresions {
	// make reusable point cut expression
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	// create a pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create a point cut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create a point cut to include package and exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageNoGetterSetter() {}
}

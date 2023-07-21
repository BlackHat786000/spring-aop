package com.learn.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransferAspect {
	
	// this will run before execution of any method named 'printTransfer'
	@Before("execution(* printTransfer(..))")
	private void beforeLogging(JoinPoint jp) {
		System.out.println(jp.getSignature());
		System.out.println("Arguement passed: "+jp.getArgs()[0].toString());
		System.out.println("before printTransfer() method called");
	}
	
	// this will run after execution of any method named 'printTransfer'
	@After("execution(* printTransfer(..))")
	private void afterLogging() {
		System.out.println("after printTransfer() method called");
	}
	
	// matches on the execution of any public method
	@Pointcut("execution(public * *(..))") // point-cut expression
    private void anyPublicOperation() {} // point-cut signature
	
	// matches on a method execution in the transfer module/package any sub-package under that.
	@Pointcut("within(com.learn.springaop.transfer..*)")
    private void inTransfer() {}
	
	// matches only on a public method execution in the transfer package
	@Before("anyPublicOperation() && inTransfer()")
    private void transferOperationAnd() {
		System.out.println("(AND) transfer operation is going to begin now.");
	}
	
	// matches on the execution of any public method OR matches on a method execution in the transfer package
//	@Before("anyPublicOperation() || inTransfer()")
//    private void transferOperationOr() {
//		System.out.println("(OR) transfer operation is going to begin now.");
//	}
	
	// After returning advice runs when a matched method execution returns normally.
//	@AfterReturning("execution(* com.learn.springaop.transfer.Transfer.dataTransfer())")
//	private void dataTransfer() {
//		System.out.println("data transfer is successfully completed now.");
//	}
	
	@AfterReturning(pointcut = "execution(* com.learn.springaop.transfer.Transfer.dataTransfer(..))", returning = "retVal")
	private void dataTransfer(String retVal) {
		System.out.println("data transfer is successfully completed now: "+retVal);
	}
	
	// named point-cut
	@Pointcut("execution(* com.learn.springaop.transfer.Transfer.throwException())")
	public void afterThrowingPointCut() {}
	
	// After throwing advice runs when a matched method execution exits by throwing an exception.
//	@AfterThrowing(pointcut = "afterThrowingPointCut()")
//	public void afterThrowing() {
//		System.out.println("Some exception has been thrown.");
//	}
	
	@AfterThrowing(pointcut = "afterThrowingPointCut()", throwing = "ex")
	public void afterThrowingGetException(Exception ex) {
		System.out.println("Exception has been thrown: "+ex);
	}
	
	@Around("execution(* com.learn.springaop.transfer.Transfer.averageDataInBits(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
//		System.out.println(args[0]+" ---- "+args[1]);
		args[0] = Integer.parseInt(args[0]+"") * 8;
		args[1] = Integer.parseInt(args[1]+"") * 8;
		Object retVal = pjp.proceed(args);
//		System.out.println(retVal);
		return "Average data: "+retVal;
	}

}

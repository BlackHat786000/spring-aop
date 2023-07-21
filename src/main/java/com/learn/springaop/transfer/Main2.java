package com.learn.springaop.transfer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.springaop.config.BeanConfig;

public class Main2 {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Transfer transfer = context.getBean(Transfer.class);
//		transfer.printTransfer("Gud Morning"); // before/after
		
//		transfer.defaultMethod(); // OR
//		transfer.beginTransfer(); // AND
		
//		transfer.dataTransfer(); // AfterReturning
//		transfer.dataTransfer("200 OK"); // AfterReturning with return value
		
//		transfer.throwException(); // AfterThrowing
		
		System.out.println(transfer.averageDataInBits(4, 5)); // Around Advice
		
	}

}

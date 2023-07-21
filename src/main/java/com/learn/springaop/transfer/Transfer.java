package com.learn.springaop.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void printTransfer(String greetings) {
		System.out.println("printTransfer() method from Transfer class executed.");
	}
	
	void defaultMethod() {
		System.out.println("default method from Transfer class called.");
	}
	
	public void beginTransfer() {
		System.out.println("transfer is completed.");
	}
	
	public String dataTransfer(String value) {
		System.out.println("data transfer begins now.");
		return "SUCCESS: "+value;
	}
	
	public int throwException() {
		return 10 / 0;
	}
	
	String averageDataInBits(int dataInBytes1, int dataInBytes2) {
		System.out.println("Data 1 in bits: "+dataInBytes1);
		System.out.println("Data 2 in bits: "+dataInBytes2);
		return (dataInBytes1 + dataInBytes2) / 2 + " bits";
	}

}

package com.splurth.periodictable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("criteria.xml");
		SymbolVerifier verifier = context.getBean(SymbolVerifier.class);
		
		String element = "Spenglerium";
		String symbol = "Ee";

		System.out.println(element + ", " + symbol + " -> " + verifier.isSymbolValid(element, symbol));
	}

}
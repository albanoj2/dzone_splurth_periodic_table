package com.splurth.periodictable;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Main class the demonstrates the functions used to solve the Splurth periodic
 * table Java code challenge.
 * 
 * @author Justin Albano
 */
public class Application {
	
	/**
	 * A map of the test elements to their corresponding test symbols, as 
	 * described in the code challenge description.
	 */
	@SuppressWarnings("serial")
	private static final Map<String, String> TEST_ELEMENTS = new HashMap<String, String>() {{
		put("Spenglerium", "Ee");
		put("Zeddemorium", "Zr");
		put("Venkmine", "Kn");
		put("Stantzon", "Zt");
		put("Melintzum", "Nn");
		put("Tullium", "Ty");
	}};

	public static void main(String[] args) {
		
		// Obtain a generator from the dependency injection container
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("criteria.xml");
		SymbolGenerator generator = context.getBean(SymbolGenerator.class);

		for (Entry<String, String> entry : TEST_ELEMENTS.entrySet()) {
			// Iterate through each element and check its validity
			System.out.println(entry.getKey() + ", " + entry.getValue() + " -> " + generator.isSymbolValid(entry.getKey(), entry.getValue()));
		}
		
		// Add a blank space between the core answer and the bonuses
		System.out.println();
		
		// Display the test results for bonus question 1
		System.out.println("Gozerium -> " + generator.getFirstValidSymbol("Gozerium"));
		System.out.println("Slimyrine -> " + generator.getFirstValidSymbol("Slimyrine"));
		
		// Add space between the first and second bonus question
		System.out.println();
		
		// Display the test result for bonus question 2
		System.out.println("Zuulon -> " + generator.getValidSymbolCount("Zuulon"));
	}

}

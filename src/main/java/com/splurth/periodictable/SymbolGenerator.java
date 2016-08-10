package com.splurth.periodictable;

import java.util.ArrayList;
import java.util.List;

import com.splurth.periodictable.criteria.SymbolCriterion;


/**
 * Generator responsible for holding the validity logic for periodic table 
 * symbols for the Splurth periodic table. This class holds a list of criteria
 * used to validate symbols, allowing new rules about the validity of symbols to
 * be added when needed.
 * 
 * @author Justin Albano
 */
public class SymbolGenerator {
	
	/**
	 * The list of criteria that is used to validate symbols in the Splurth
	 * periodic table.
	 */
	private List<SymbolCriterion> criteria;
	
	/**
	 * A string representing the ordered list of valid characters that can be 
	 * used in a symbol in the Splurth periodic table.
	 */
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	
	/**
	 * Creates the generator, using the supplied criteria as the validity rules
	 * for validating symbols.
	 * 
	 * @param criteria
	 * 		The criteria used to validate symbols in the Splurth periodic table.
	 */
	public SymbolGenerator (List<SymbolCriterion> criteria) {
		this.criteria = criteria;
	}

	/**
	 * Checks if the supplied symbol is valid for the supplied element.
	 * 
	 * @param element
	 * 		The element used to check the validity of the supplied symbol.
	 * @param symbol
	 * 		The symbol whose validity is desired.
	 * 
	 * @return
	 * 		True if the supplied symbol is valid with respect to the supplied
	 * 		element; false otherwise.
	 */
	public boolean isSymbolValid (String element, String symbol) {

		for (SymbolCriterion criterion: this.criteria) {
			// Iterate through each of the criteria and make sure the symbol is
			// valid with respect to each criterion
			
			if (!criterion.isValid(element, symbol)) {
				// One of the criterion found the symbol to be invalid
				return false;
			}
		}
		
		// The symbol is valid for all criteria
		return true;
	}
	
	/**
	 * Obtains the first valid symbol corresponding to the supplied element.
	 * 
	 * @param element
	 * 		The element whose corresponding first valid symbol should be found.
	 * 
	 * @return
	 * 		The first valid symbol corresponding to the supplied element. If no
	 * 		valid symbol can be found, a blank string is returned.
	 */
	public String getFirstValidSymbol (String element) {

		for (String symbol: SymbolGenerator.getPossibleSymbols()) {
			// Test each symbol until a valid one is found
			
			if (this.isSymbolValid(element, symbol)) {
				// A valid symbol was found
				return symbol;
			}
		}
		
		// No valid symbol was found
		return "";
	}
	
	/**
	 * Obtains the number of unique valid symbols that correspond to the 
	 * supplied element.
	 * 
	 * @param element
	 * 		The element whose number of unique valid symbols is desired.
	 * 
	 * @return
	 * 		The number of unique valid symbols that can be generated from the
	 * 		supplied element.
	 */
	public long getValidSymbolCount (String element) {
		
		if (element.isEmpty()) {
			// An empty element was supplied (there are no valid symbols); 
			// although the iteration below would catch this event, this check
			// removes the implicitness of the iteration below
			return 0;
		}
		
		// Filter out all invalid symbols and then count the results
		return SymbolGenerator.getPossibleSymbols()
			.parallelStream()
			.filter(symbol -> this.isSymbolValid(element, symbol))
			.count();
	}
	
	/**
	 * Obtains a list of all possible symbols with a length of two characters.
	 * 
	 * @return
	 * 		A list of all possible symbols with a length of two characters, 
	 * 		where the first character in each symbol is capitalized, as per the 
	 * 		rules associated with valid Splurth periodic table symbols.
	 */
	private static List<String> getPossibleSymbols () {

		// Create the stub for the possible symbols
		List<String> symbols = new ArrayList<>();
		
		for (int i = 0; i < 26; i++) {
			// Iterate through the index of the first letter
			for (int j = 0; j < 26; j++) {
				// Iterate through the index of the second letter and push the 
				// generated symbol into the list
				symbols.add("" + ALPHABET.substring(i, i + 1).toUpperCase() + ALPHABET.substring(j, j + 1));
			}
		}
		
		return symbols;
	}
}

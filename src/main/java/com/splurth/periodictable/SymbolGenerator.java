package com.splurth.periodictable;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.text.WordUtils;

import com.splurth.periodictable.criteria.SymbolCriterion;

public class SymbolGenerator {
	
	private List<SymbolCriterion> criteria;
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
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
				// A valid symbol was found (capitalize the first character to
				// match the expected output form)
				return WordUtils.capitalize(symbol);
			}
		}
		
		// No valid symbol was found
		return "";
	}
	
	private static List<String> getPossibleSymbols () {

		// Create the stub for the possible symbols
		List<String> symbols = new ArrayList<>();
		
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				symbols.add("" + ALPHABET.substring(i, i + 1) + ALPHABET.substring(j, j + 1));
			}
		}
		
		return symbols;
	}
}

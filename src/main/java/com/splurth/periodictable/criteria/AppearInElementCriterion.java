package com.splurth.periodictable.criteria;


/**
 * Criterion that verifies that all letters in the supplied symbol are found 
 * within the supplied element (case insensitive). The occurrences of the 
 * letters in the symbol do not need to be unique within the element. For 
 * example, if the element is "Something" and the symbol is "Tt," although there
 * are two occurrences of "T" in the symbol, and only one in the element, this 
 * validates this criterion.
 * 
 * @author Justin Albano
 */
public class AppearInElementCriterion implements SymbolCriterion {

	/**
	 * {@inheritDoc}
	 */
	public boolean isValid(String element, String symbol) {
		
		if (element.isEmpty() || symbol.isEmpty()) {
			// Either the element or the symbol is empty symbol is empty (the
			// element being empty is implicitly handled in the loop below, with
			// 0 iterations, but this is a shortcut to remove the implicit empty
			// iteration)
			return false;
		}

		for (char symbolCharacter: symbol.toLowerCase().toCharArray()) {
			// Iterate through character (case insensitive) of the symbol
			
			if (element.toLowerCase().indexOf(symbolCharacter) == -1) {
				// The current symbol letter is not found in the element (in a
				// case insensitive manner)
				return false;
			}
		}
		
		return true;
	}

}

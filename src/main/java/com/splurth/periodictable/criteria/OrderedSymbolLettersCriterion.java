package com.splurth.periodictable.criteria;

/**
 * Criterion that verifies that the first two letters of the supplied symbol are
 * found in order within the supplied. If the first two letters of the symbol
 * are the same, this criterion will verify that the second instance of the 
 * repeated letter is found <em>after</em> the first instance of the letter 
 * (there are at least two occurrences of the repeated letter) in the element.
 * 
 * @author Justin Albano
 */
public class OrderedSymbolLettersCriterion implements SymbolCriterion {

	/**
	 * {@inheritDoc}
	 */
	public boolean isValid(String element, String symbol) {
		
		if (symbol.length() < 2) {
			// There must be at least two characters for this algorithm to work
			return false;
		}

		// Obtain the first and second letters from the symbol (as lower case)
		char firstLetter = symbol.toLowerCase().charAt(0);
		char secondLetter = symbol.toLowerCase().charAt(1);
		
		// Obtain the position of the first letter
		int firstLetterIndex = element.toLowerCase().indexOf(firstLetter);
		
		if (firstLetterIndex > -1) {
			// The first letter is present (check if the second letter appears 
			// after the first letter by looking for the index of the second 
			// letter after the index of the first letter (and that the two are
			// not the same index)
			int secondLetterIndex = element.toLowerCase().indexOf(secondLetter, firstLetterIndex + 1);
			
			// Ensure the second letter was found
			return secondLetterIndex > -1;
		}
		else {
			// The first letter is not present
			return false;
		}
	}

}

package com.splurth.periodictable.criteria;


/**
 * Criterion verifying that the supplied symbol is exactly two characters in 
 * length. The length and value of the supplied element is disregarded.
 * 
 * @author Justin Albano
 *
 */
public class TwoLettersCriterion implements SymbolCriterion {

	/**
	 * {@inheritDoc}
	 */
	public boolean isValid (String element, String symbol) {
		return symbol.length() == 2;
	}
}

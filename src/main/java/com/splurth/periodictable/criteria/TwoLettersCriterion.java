package com.splurth.periodictable.criteria;

public class TwoLettersCriterion implements SymbolCriterion {

	public boolean isValid (String element, String symbol) {
		return symbol.length() == 2;
	}
}

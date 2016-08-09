package com.splurth.periodictable;

import java.util.List;

import com.splurth.periodictable.criteria.SymbolCriterion;

public class SymbolVerifier {
	
	private List<SymbolCriterion> criteria;
	
	public SymbolVerifier (List<SymbolCriterion> criteria) {
		this.criteria = criteria;
	}

	public boolean isSymbolValid (String element, String symbol) {

		for (SymbolCriterion criterion: this.criteria) {
			if (!criterion.isValid(element, symbol)) {
				return false;
			}
		}
		
		return true;
	}
}

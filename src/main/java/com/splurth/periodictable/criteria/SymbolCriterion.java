package com.splurth.periodictable.criteria;


/**
 * An interface representing the strategies that can be used as criteria for 
 * validating symbols in the Splurth periodic table with respect to the supplied
 * element.
 * 
 * @author Justin Albano
 */
public interface SymbolCriterion {

	/**
	 * Checks the validity of a symbol with respect to the supplied element.
	 * 
	 * @param element
	 * 		The element against which the supplied symbol will be judged.
	 * @param symbol
	 * 		The symbol whose validity is desired.
	 * 
	 * @return
	 * 		True if the supplied symbol is valid with respect to the supplied 
	 * 		element; false otherwise.
	 */
	public boolean isValid (String element, String symbol);
}

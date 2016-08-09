package com.splurth.periodictable.test.criteria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.splurth.periodictable.criteria.OrderedSymbolLettersCriterion;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:criteria.xml"})
public class OrderedSymbolLettersCriterionTest {
	
	@Autowired
	private OrderedSymbolLettersCriterion criterion;

	@Test
	public void testBothLettersAppearInCorrectOrderEnsureInvalid () {
		assertTrue(criterion.isValid("Test", "Et"));
	}

	@Test
	public void testNeitherLetterAppearsEnsureInvalid () {
		assertFalse(criterion.isValid("Test", "Xy"));
	}
	
	@Test
	public void testFirstLetterAppearsButNotSecondEnsureInvalid () {
		assertFalse(criterion.isValid("Test", "Ey"));
	}
	
	@Test
	public void testBothLettersAppearInOppositeOrderEnsureInvalid () {
		assertFalse(criterion.isValid("Test", "Se"));
	}
	
	@Test
	public void testBothLettersAreTheSameAndBothPresentEnsureValid () {
		assertTrue(criterion.isValid("Test", "Tt"));
	}
	
	@Test
	public void testBothLettersAreTheSameAndOnlyFoundOnceInElementEnsureInvalid () {
		assertFalse(criterion.isValid("Test", "Ee"));
	}
	
	@Test
	public void testBothLettersPresentInOrderAndAdjacentEnsureValid () {
		assertTrue(criterion.isValid("Test", "Te"));
	}
	
	@Test
	public void testBothLettersPresentOutOfOrderAndAdjacentEnsureInvalid () {
		assertFalse(criterion.isValid("Test", "Se"));
	}
	
	@Test
	public void testFirstLetterAtFirstIndexSecondLetterAtLastIndexEnsureValid () {
		assertTrue(criterion.isValid("Something", "Sg"));
	}
	
	@Test
	public void testFirstLetterAtLastIndexSecondLetterAtFirstIndexEnsureInvalid () {
		assertFalse(criterion.isValid("Something", "Gs"));
	}
	
	@Test
	public void testSymbolIsEmptyStringEnsureInvalid () {
		assertFalse(criterion.isValid("Something", ""));
	}
	
	@Test
	public void testSymbolIsOneCharacterStringEnsureInvalid () {
		assertFalse(criterion.isValid("Something", "E"));
	}
}

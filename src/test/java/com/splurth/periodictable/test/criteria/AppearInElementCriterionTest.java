package com.splurth.periodictable.test.criteria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.splurth.periodictable.criteria.AppearInElementCriterion;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:criteria.xml"})
public class AppearInElementCriterionTest {
	
	@Autowired
	private AppearInElementCriterion criterion;
	
	@Test
	public void testEmptyElementEnsureInvalid () {
		assertFalse(this.criterion.isValid("", "Te"));
	}
	
	@Test
	public void testEmptySymbolEnsureInvalid () {
		assertFalse(this.criterion.isValid("Something", ""));
	}

	@Test
	public void testBothEmptyElementAndSymbolEnsureInvalid () {
		assertFalse(this.criterion.isValid("", ""));
	}
	
	@Test
	public void testOnlySymbolLetterIsFoundEnsureValid () {
		assertTrue(this.criterion.isValid("Something", "e"));
	}
	
	@Test
	public void testOnlySymbolLetterIsFoundDifferentCaseEnsureValid () {
		assertTrue(this.criterion.isValid("Something", "E"));
	}
	
	@Test
	public void testFirstSymbolLetterFoundButSecondIsNotFoundEnsureInvalid () {
		assertFalse(this.criterion.isValid("Something", "ex"));
	}
	
	@Test
	public void testFirstSymbolLetterNotFoundButSecondIsFoundEnsureInvalid () {
		assertFalse(this.criterion.isValid("Something", "xe"));
	}
	
	@Test
	public void testRepeatedSymbolLetterFoundWithOnlyOneOccurrenceInElementEnsureValid () {
		assertTrue(this.criterion.isValid("Something", "ss"));
	}
	
	@Test
	public void testRepeatedSymbolLetterFoundWithTwoOccurrencesInElementEnsureValid () {
		assertTrue(this.criterion.isValid("Test", "tt"));
	}
}

package com.splurth.periodictable.test.criteria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.splurth.periodictable.criteria.TwoLettersCriterion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:criteria.xml"})
public class TwoLettersCriterionTest {
	
	@Autowired
	private TwoLettersCriterion criterion;
	
	@Test
	public void testEmptyElementWithValidSymbolEnsureValid () {
		assertTrue(this.criterion.isValid("", "Tt"));
	}
	
	@Test
	public void testEmptySymbolEnsureInvalid () {
		assertFalse(this.criterion.isValid("Something", ""));
	}

	@Test
	public void testOneLetterSymbolEnsureInvalid () {
		assertFalse(this.criterion.isValid("Something", "S"));
	}
	
	@Test
	public void testTwoLetterSymbolEnsureValid () {
		assertTrue(this.criterion.isValid("Something", "So"));
	}
	
	@Test
	public void testTwoLetterSymbolNotIncludedInElementEnsureValid () {
		assertTrue(this.criterion.isValid("Something", "Xx"));
	}
	
	@Test
	public void testThreeLetterSymbolEnsureInvalid () {
		assertFalse(this.criterion.isValid("Something", "Str"));
	}
}

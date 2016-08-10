package com.splurth.periodictable.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.splurth.periodictable.SymbolGenerator;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:criteria.xml"})
public class SymbolGeneratorTest {

	@Autowired
	private SymbolGenerator generator;
	
	@Test
	public void testSpengleriumElementEeSymbolEnsureValid () {
		assertTrue(this.generator.isSymbolValid("Spenglerium", "Ee"));
	}
	
	@Test
	public void testEmptyElementAndEmptySymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("", ""));
	}
	
	@Test
	public void testEmptyElementAndNonemptySymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("", "Tt"));
	}
	
	@Test
	public void testNonemptyElementAndEmptySymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Something", ""));
	}
	
	@Test
	public void testOneLetterSymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Something", "S"));
	}
	
	@Test
	public void testZeddemoriumElementZrSymbolEnsureValid () {
		assertTrue(this.generator.isSymbolValid("Zeddemorium", "Zr"));
	}
	
	@Test
	public void testVenkmineElementKnSymbolEnsureValid () {
		assertTrue(this.generator.isSymbolValid("Venkmine", "Kn"));
	}
	
	@Test
	public void testStantzonElementZtSymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Stantzon", "Zt"));
	}
	
	@Test
	public void testMelintzumElementNnSymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Melintzum", "Nn"));
	}
	
	@Test
	public void testTulliumElementTySymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Tullium", "Ty"));
	}
}

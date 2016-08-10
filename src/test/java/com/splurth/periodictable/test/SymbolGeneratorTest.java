package com.splurth.periodictable.test;

import static org.junit.Assert.assertEquals;
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
	public void testSymbolVerificationSpengleriumElementEeSymbolEnsureValid () {
		assertTrue(this.generator.isSymbolValid("Spenglerium", "Ee"));
	}
	
	@Test
	public void testSymbolVerificationEmptyElementAndEmptySymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("", ""));
	}
	
	@Test
	public void testSymbolVerificationEmptyElementAndNonemptySymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("", "Tt"));
	}
	
	@Test
	public void testSymbolVerificationNonemptyElementAndEmptySymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Something", ""));
	}
	
	@Test
	public void testSymbolVerificationOneLetterSymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Something", "S"));
	}
	
	@Test
	public void testSymbolVerificationZeddemoriumElementZrSymbolEnsureValid () {
		assertTrue(this.generator.isSymbolValid("Zeddemorium", "Zr"));
	}
	
	@Test
	public void testSymbolVerificationVenkmineElementKnSymbolEnsureValid () {
		assertTrue(this.generator.isSymbolValid("Venkmine", "Kn"));
	}
	
	@Test
	public void testSymbolVerificationStantzonElementZtSymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Stantzon", "Zt"));
	}
	
	@Test
	public void testSymbolVerificationMelintzumElementNnSymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Melintzum", "Nn"));
	}
	
	@Test
	public void testSymbolVerificationTulliumElementTySymbolEnsureInvalid () {
		assertFalse(this.generator.isSymbolValid("Tullium", "Ty"));
	}
	
	@Test
	public void testGetFirstValidSymbolForGozeriumElementEnsureEi () {
		assertEquals(this.generator.getFirstValidSymbol("Gozerium"), "Ei");
	}
	
	@Test
	public void testGetFirstValidSymbolForSlimyrineElementEnsureIe () {
		assertEquals(this.generator.getFirstValidSymbol("Slimyrine"), "Ie");
	}
	
	@Test
	public void testGetFirstValidSymbolForInvalidElementEnsureEmptyString () {
		assertEquals(this.generator.getFirstValidSymbol("X"), "");
	}
	
	@Test
	public void testGetValidSymbolCountForZuulonEnsure11 () {
		assertEquals(this.generator.getValidSymbolCount("Zuulon"), 11);
	}
	
	@Test
	public void testGetValidSymbolCountForEmptyElementEnsure0 () {
		assertEquals(this.generator.getValidSymbolCount(""), 0);
	}
}

package com.jpmc.report.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jpmc.report.model.Currency;

public class CurrencyTest {

	@Test
	public void testValidCurrency() {
		assertEquals(Currency.valueOf("SDP"), Currency.SDP);
		assertEquals(Currency.valueOf("CAD"), Currency.CAD);
		assertEquals(Currency.valueOf("USD"), Currency.USD);
		assertEquals(Currency.valueOf("EUR"), Currency.EUR);
		assertEquals(Currency.valueOf("GBP"), Currency.GBP);
		assertEquals(Currency.valueOf("DRG"), Currency.DRG);
		assertEquals(Currency.valueOf("AED"), Currency.AED);
		assertEquals(Currency.valueOf("SGP"), Currency.SGP);
		assertEquals(Currency.valueOf("SAR"), Currency.SAR );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCurrrency() {
		Currency.valueOf("AAA");
		Currency.valueOf("DDE");
	}

}

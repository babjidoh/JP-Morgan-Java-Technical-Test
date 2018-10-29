package com.jpmc.report.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.report.model.TradeOperation;

public class TradeOperationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testValidTradeOperation() {
		assertEquals(TradeOperation.valueOf("BUY"), TradeOperation.BUY);
		assertEquals(TradeOperation.valueOf("SELL"), TradeOperation.SELL);
		
		assertEquals(TradeOperation.BUY.getOperation(), "outgoing");
		assertEquals(TradeOperation.SELL.getOperation(), "incoming");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTradeOperation() {
		TradeOperation.valueOf("LLL");
	}

}

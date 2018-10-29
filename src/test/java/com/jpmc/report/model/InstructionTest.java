package com.jpmc.report.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.report.model.Currency;
import com.jpmc.report.model.Instruction;
import com.jpmc.report.model.TradeOperation;

public class InstructionTest {
	
	Instruction instruction1, instruction2,instruction3;

	@Before
	public void setUp() throws Exception {
		instruction1 = new Instruction("foo",TradeOperation.BUY , 0.50, Currency.SDP, LocalDate.of(2018, Month.FEBRUARY, 4), LocalDate.of(2018, Month.OCTOBER, 27), 200, 100.25);
		instruction2 = new Instruction("foo",TradeOperation.BUY , 0.50, Currency.SAR, LocalDate.of(2018, Month.FEBRUARY, 4), LocalDate.now(), 200, 100.25);
		instruction3 = new Instruction("foo",TradeOperation.BUY , 0.50, Currency.AED, LocalDate.of(2018, Month.FEBRUARY, 4), LocalDate.of(2018, Month.OCTOBER, 26), 200, 100.25);
	}

	@Test
	public void testIsSettlementDate() {
		assertEquals(instruction3.isSettlementDate(), false);
		assertEquals(instruction2.isSettlementDate(), true);
	}

	@Test
	public void testSetSettlementDate() {
		assertEquals(instruction1.getSettlementDate().toString(), "2018-10-29");
	}

	@Test
	public void testGetAmountOfTrade() {
		assertEquals(instruction1.getSettlementDate().toString(), "2018-10-29");
	}

}

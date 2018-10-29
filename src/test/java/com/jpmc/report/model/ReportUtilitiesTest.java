package com.jpmc.report.model;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class ReportUtilitiesTest {

	ReportUtilities rep = new ReportUtilities();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		
	}


	@Test
	public void rankEntitiesByInstructionAmount_WithEmptyInstructionList_ThrowsIllegalArgException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Instructions and operations must not be null or empty for entity ranking");
		rep.rankEntitiesByInstructionAmount(new ArrayList<>(),TradeOperation.BUY);
	}

	@Test
	public void rankEntitiesByInstructionAmount_WithNullInstructionList_ThrowsIllegalArgException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Instructions and operations must not be null or empty for entity ranking");
		rep.rankEntitiesByInstructionAmount(null, TradeOperation.BUY);
	}  

	@Test
	public void calculateDailySettledAmountt_WithEmptyInstructionList_ThrowsIllegalArgException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Instructions and operations must not be null or empty for amount settled calculation");
		rep.calculateDailySettledAmount(new ArrayList<>());
	}

	@Test
	public void calculateDailySettledAmount_WithNullInstructionList_ThrowsIllegalArgException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Instructions and operations must not be null or empty for amount settled calculation");
		rep.calculateDailySettledAmount(null);
	}         

}



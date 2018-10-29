package com.jpmc.report.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.report.model.OtherWeeklyService;

public class OtherWeeklyServiceTest {

	OtherWeeklyService otherWeeklyService;
	@Before
	public void setUp() throws Exception {
		otherWeeklyService = new OtherWeeklyService();
	}

	@Test
	public void testGetNextWorkingDay() {
		 assertEquals(otherWeeklyService.getNextWorkingDay(LocalDate.of(2018, Month.OCTOBER, 26)), LocalDate.of(2018, Month.OCTOBER, 28));	 
		 assertEquals(otherWeeklyService.getNextWorkingDay(LocalDate.of(2018, Month.OCTOBER, 25)), LocalDate.of(2018, Month.OCTOBER, 25));
		 assertEquals(otherWeeklyService.getNextWorkingDay(LocalDate.of(2018, Month.OCTOBER, 27)), LocalDate.of(2018, Month.OCTOBER, 28));	
	}

}

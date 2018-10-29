package com.jpmc.report.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.report.model.StandardWeeklyService;

public class StandardWeeklyServiceTest {

	StandardWeeklyService standardWeeklyService;
	@Before
	public void setUp() throws Exception {
		standardWeeklyService = new StandardWeeklyService();
	}

	@Test
	public void testGetNextWorkingDay() {
		 assertEquals(standardWeeklyService.getNextWorkingDay(LocalDate.of(2018, Month.OCTOBER, 26)), LocalDate.of(2018, Month.OCTOBER, 26));	 
		 assertEquals(standardWeeklyService.getNextWorkingDay(LocalDate.of(2018, Month.OCTOBER, 28)), LocalDate.of(2018, Month.OCTOBER, 29));
		 assertEquals(standardWeeklyService.getNextWorkingDay(LocalDate.of(2018, Month.OCTOBER, 27)), LocalDate.of(2018, Month.OCTOBER, 29));	
	}

}

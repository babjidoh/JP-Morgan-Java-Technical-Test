package com.jpmc.report;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.jpmc.report.model.Currency;
import com.jpmc.report.model.InputDataList;
import com.jpmc.report.model.Instruction;
import com.jpmc.report.model.TradeOperation;

/**
 * 
 * Sample data that represents the instructions sent by various clients 
 * to JP Morgan to execute in the international market.
 * 
 */
public class GenerateInstructionData implements InputDataList {
	
    
	public List<Instruction> retrieveInstructions() {

        List<Instruction> instructions = new ArrayList<Instruction>();
        
        instructions.add(new Instruction("foo",TradeOperation.BUY , 0.50, Currency.SAR, LocalDate.of(2018, Month.FEBRUARY, 4), LocalDate.now(), 200, 100.25));
        instructions.add(new Instruction("foo",TradeOperation.BUY , 0.50, Currency.SAR, LocalDate.of(2018, Month.FEBRUARY, 4), LocalDate.now(), 200, 100.25)); 
        instructions.add(new Instruction("txz",TradeOperation.SELL , 0.22, Currency.AED, LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2018, Month.OCTOBER, 28), 200, 150.50));
        instructions.add(new Instruction("bar",TradeOperation.BUY , 0.48, Currency.SAR, LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2018, Month.OCTOBER, 28), 700, 120.25));
        instructions.add(new Instruction("xyz",TradeOperation.SELL , 0.22, Currency.EUR, LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2018, Month.OCTOBER, 28), 280, 456.75));
        instructions.add(new Instruction("abc",TradeOperation.BUY , 1.12, Currency.AED, LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2018, Month.OCTOBER, 28), 200, 452.25));
        instructions.add(new Instruction("axy",TradeOperation.SELL , 0.89, Currency.SAR, LocalDate.of(2016, Month.JANUARY, 1), LocalDate.now(), 250, 270.25));
        instructions.add(new Instruction("dbs",TradeOperation.BUY , 0.38, Currency.EUR, LocalDate.of(2016, Month.JANUARY, 1), LocalDate.now(), 400, 240.25));
        instructions.add(new Instruction("txz",TradeOperation.SELL , 0.22, Currency.AED, LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2018, Month.OCTOBER, 28), 200, 150.50));
      
        return instructions;
    }
}

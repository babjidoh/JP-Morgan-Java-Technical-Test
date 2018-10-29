package com.jpmc.report.model;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toMap;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jpmc.report.model.Instruction;
import com.jpmc.report.model.TradeOperation;

public class ReportUtilities {
	
	/**
     * Calculate the daily settled amount  
     */
	
    public Map<TradeOperation, BigDecimal> calculateDailySettledAmount(List<Instruction> instructions) {

        if (instructions == null || instructions.isEmpty())
            throw new IllegalArgumentException("Instructions and operations must not be null or empty for amount settled calculation");

        return instructions.stream()
                .filter(instruction -> instruction.isSettlementDate())
                .collect(groupingBy(Instruction::getTradeOperation, mapping(Instruction::getAmountOfTrade, reducing(BigDecimal.ZERO, BigDecimal::add))));
                
    }
    


  public Map<String, BigDecimal> rankEntitiesByInstructionAmount(List<Instruction> instructions, TradeOperation op) {

        if (instructions == null || instructions.isEmpty() || op == null)
            throw new IllegalArgumentException("Instructions and operations must not be null or empty for entity ranking");

        return instructions.stream()
                .filter(instruction -> instruction.isSettlementDate() && instruction.getTradeOperation().equals(op))
                .collect(groupingBy(Instruction::getEntity,
                        mapping(Instruction::getAmountOfTrade, reducing(BigDecimal.ZERO, BigDecimal::add))))
                .entrySet().stream()
                .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }
  

}

package com.jpmc.report;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.jpmc.report.model.InputDataList;
import com.jpmc.report.model.ReportUtilities;
import com.jpmc.report.model.TradeOperation;

/**
 * Daily Trade Reporting Application 
 * @author Babajide Obisesan
 * @version 1.0
 */

public class ReportingApplication {
	public static void main(String[] args) {
		
		

		System.out.println("---------------------------  JP Morgan Chase  ---------------------------\n");
		System.out.println("--------------------------- instructions sent by various clients to JP Morgan  ---------------------------\n");
		System.out.println("Entity" +"\t" +"Trade" + "\t" +"AgreedFx" +"\t" +"Currency" + "\t" +"InstructionDate" +"\t"+"SettlementDate" + "\t" +"Units" +"\t" +"Unit Price" + "\t" +"Amount");
		
		try {
			InputDataList data = new GenerateInstructionData();
			ReportUtilities rep  = new ReportUtilities();
			AtomicInteger counter1 = new AtomicInteger(0);
			AtomicInteger counter2 = new AtomicInteger(0);
			
			data.retrieveInstructions().forEach(System.out::println);
			
			System.out.println("\n\n\n---------------------------  Daily Forex Trading Report  ---------------------------\n\n\n");
			
			Map<TradeOperation, BigDecimal>  results = rep.calculateDailySettledAmount(data.retrieveInstructions());
			results.forEach((k, v)-> {
				System.out.println("\nAmount in USD settled " + k.getOperation() + " " + v);
			});
			
			//Ranking of entities based on outgoing amount
			Map<String, BigDecimal>  ranks = rep.rankEntitiesByInstructionAmount(data.retrieveInstructions(),TradeOperation.BUY);
			System.out.println("\n\n\nCurrent ranking of entities based on " + TradeOperation.BUY.getOperation() + " Operations");
			System.out.println("Rank" +"\t\t" +"Entity" + "\t\t" +"Amount");
			
			ranks.forEach((k1, v1)-> {
				counter1.addAndGet(1);
				System.out.println(counter1 + "\t\t" +  k1 + "\t\t" +  v1);
			});
			
			
			// Ranking of entities based on incoming amount
			Map<String, BigDecimal>  rankSell = rep.rankEntitiesByInstructionAmount(data.retrieveInstructions(),TradeOperation.SELL);
			System.out.println("\n\n\nCurrent ranking of entities based on " + TradeOperation.SELL.getOperation() + " Operations");
			System.out.println("Rank" +"\t\t" +"Entity" + "\t\t" +"Amount");
			
			rankSell.forEach((k1, v1)-> {
				counter2.addAndGet(1);
				System.out.println(counter2 + "\t\t" +  k1 + "\t\t" +  v1);
			});



		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("\n\n\n-------------------------------------  End Report  -------------------------------------");
		System.out.println("--------------------------  JP Morgan Chase Copyright \u00a9 2018  --------------------------");


	}

}

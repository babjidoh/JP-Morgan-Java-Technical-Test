/**
 * 
 */
package com.jpmc.report.model;

/**
 * 
 *
 */
import java.math.BigDecimal;
import java.time.LocalDate;

import com.jpmc.report.model.OtherWeeklyService;
import com.jpmc.report.model.StandardWeeklyService;

public class Instruction {

	private final String entity;
	private final TradeOperation tradeOperation;
	private final double agreedFx;
	private final Currency currency;
	private final LocalDate instructionDate;
	private LocalDate instructedSettlementDate;
	private LocalDate settlementDate;
	private final int units;
	private final double unitPrice;


	/**
	 * @param entity
	 * @param tradeOperation
	 * @param agreedFx
	 * @param currency
	 * @param instructionDate
	 * @param settlementDate
	 * @param units
	 * @param unitPrice
	 */
	public Instruction(String entity, TradeOperation tradeOperation, double agreedFx, Currency currency,
			LocalDate instructionDate, LocalDate instructedSettlementDate, int units, double unitPrice) {
		super();
		this.entity = entity;
		this.tradeOperation = tradeOperation;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.instructedSettlementDate = instructedSettlementDate;
		settlementDate();
		this.units = units;
		this.unitPrice = unitPrice;
	}

	

	/**
	 * A trade can only be settled on a working day
	 * The method checks the currency of the trade and  
	 * @ call the appropriate method that set the settlement date to a working day if date falls to weekend 
	 */
	
	private void settlementDate() {
		if (currency == Currency.AED || currency == Currency.SAR) {
			this.settlementDate = new OtherWeeklyService().getNextWorkingDay(this.instructedSettlementDate);
		}
		else {
			this.settlementDate = new StandardWeeklyService().getNextWorkingDay(this.instructedSettlementDate);
		}
	}

	/**
	 * The method Compare the settlement date with todays date  and return a true if the are equal 
	 * @return boolean true 
	 */
	public boolean isSettlementDate() {
		return this.settlementDate.equals(LocalDate.now());
	}

	/**
	 * @return the settlementDate
	 */
	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * @return the tradeOperation
	 */
	public TradeOperation getTradeOperation() {
		return tradeOperation;
	}


	/**
	 * @return the agreedFx
	 */
	public double getAgreedFx() {
		return agreedFx;
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @return the instructionDate
	 */
	public LocalDate getInstructionDate() {
		return instructionDate;
	}


	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	
	/* 
	 * @return the trade Amount in BigDecimal for accurate calculation of currency in USD
	 * USD amount of a trade = Price per unit * Units * Agreed Fx 
	 */

	public BigDecimal getAmountOfTrade() {

		return BigDecimal.valueOf(units).multiply(BigDecimal.valueOf(agreedFx)).multiply(BigDecimal.valueOf(unitPrice)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	/* 
	 * @ Override the toString 
	 */

	@Override
	public String toString() {

		return this.entity + "\t" + this.tradeOperation
				+ "\t" + this.agreedFx + "\t\t" + this.currency 
				+ "\t\t" + this.instructionDate + "\t" + this.settlementDate 
				+ "\t" + this.units + "\t" + this.unitPrice + "\t\t" + this.getAmountOfTrade();
	}





}

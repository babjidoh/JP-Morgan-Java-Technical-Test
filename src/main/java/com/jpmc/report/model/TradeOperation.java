package com.jpmc.report.model;

/**
 * Corresponds to trade type BUY/SELL
 */

public enum TradeOperation {

    BUY("outgoing"), SELL("incoming");

    private String operation;

    TradeOperation(String operation) {
        this.operation = operation;
    }


    public String getOperation() {
        return this.operation;
    }

}

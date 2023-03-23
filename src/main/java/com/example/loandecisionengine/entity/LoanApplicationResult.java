package com.example.loandecisionengine.entity;

public class LoanApplicationResult {

    private String decision;
    private int amount;

    public LoanApplicationResult(String decision, int amount) {
        this.decision = decision;
        this.amount = amount;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}

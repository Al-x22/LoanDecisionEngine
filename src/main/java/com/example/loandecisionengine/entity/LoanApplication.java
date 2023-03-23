package com.example.loandecisionengine.entity;

import com.example.loandecisionengine.service.GenerateLoanResult;

public class LoanApplication {

    // LoanApplication needs a method in which it Will call GenerateLoanResult giving an output with the
    // result

    private long personalCode;
    private int loanAmount;
    private int loanPeriod;

    public LoanApplication() {}

    public LoanApplication(long personalCode, int loanAmount, int loanPeriod) {
        this.personalCode = personalCode;
        this.loanAmount = loanAmount;
        this.loanPeriod = loanPeriod;
    }

    public long getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(long personalCode) {
        this.personalCode = personalCode;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }
}

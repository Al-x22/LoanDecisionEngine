package com.example.loandecisionengine.entity;

public class LoanApplicationResult {

    private boolean decision;
    private int possibleAmountInOriginalMonths;
    private int finalAmount;
    private int finalMonths;
    private LoanApplication applicationForm;

    public LoanApplicationResult(boolean decision) {
        this.decision = decision;
    }
    public LoanApplicationResult(boolean decision, int possibleAmountInOriginalMonths) {
        this.decision = decision;
    }
    public LoanApplicationResult(boolean decision, int possibleAmountInOriginalMonths, int finalAmount, int finalMonths, LoanApplication applicationForm) {
        this.decision = decision;
        this.possibleAmountInOriginalMonths = possibleAmountInOriginalMonths;
        this.finalAmount = finalAmount;
        this.finalMonths = finalMonths;
        this.applicationForm = applicationForm;
    }
    public boolean getDecision() {
        return decision;
    }
    public void setDecision(boolean decision) {
        this.decision = decision;
    }
    public int getPossibleAmountInOriginalMonths() {
        return possibleAmountInOriginalMonths;
    }

    public void setPossibleAmountInOriginalMonths(int possibleAmountInOriginalMonths) {
        this.possibleAmountInOriginalMonths = possibleAmountInOriginalMonths;
    }
    public int getFinalAmount() {
        return finalAmount;
    }
    public void setFinalAmount(int finalAmount) {
        this.finalAmount = finalAmount;
    }
    public int getFinalMonths() {
        return finalMonths;
    }

    public void setFinalMonths(int finalMonths) {
        this.finalMonths = finalMonths;
    }
    public LoanApplication getApplicationForm() {
        return applicationForm;
    }
    public void setApplicationForm(LoanApplication applicationForm) {
        this.applicationForm = applicationForm;
    }

}

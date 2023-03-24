package com.example.loandecisionengine.entity;

public class LoanApplicationResult {

    private boolean decision;
    private int possibleAmountInOriginalMonths;
    private int finalAmount;
    private int finalLoanPeriod = 0;
    private String motiveMsg;
    private LoanApplication applicationForm;

    public LoanApplicationResult(boolean decision, String motiveMsg) {
        this.decision = decision;
        this.motiveMsg = motiveMsg;
    }

    public LoanApplicationResult(boolean decision, int possibleAmountInOriginalMonths, String motiveMsg) {
        this.decision = decision;
        this.possibleAmountInOriginalMonths = possibleAmountInOriginalMonths;
        this.motiveMsg = motiveMsg;
    }

    public LoanApplicationResult(boolean decision, int possibleAmountInOriginalMonths,
                                 int finalAmount, int finalLoanPeriod, String motiveMsg, LoanApplication applicationForm) {
        this.decision = decision;
        this.possibleAmountInOriginalMonths = possibleAmountInOriginalMonths;
        this.finalAmount = finalAmount;
        this.finalLoanPeriod = finalLoanPeriod;
        this.motiveMsg = motiveMsg;
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

    public int getFinalLoanPeriod() {
        return finalLoanPeriod;
    }

    public void setFinalLoanPeriod(int finalLoanPeriod) {
        this.finalLoanPeriod = finalLoanPeriod;
    }

    public String getMotiveMsg() { return motiveMsg;}

    public void setMotiveMsg(String motiveMsg) {this.motiveMsg = motiveMsg;}

    public LoanApplication getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(LoanApplication applicationForm) {
        this.applicationForm = applicationForm;
    }

}

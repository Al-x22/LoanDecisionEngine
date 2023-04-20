package com.example.loandecisionengine.service;

import com.example.loandecisionengine.entity.LoanApplication;
import com.example.loandecisionengine.entity.LoanApplicationResult;
import com.example.loandecisionengine.entity.User;
import com.example.loandecisionengine.repository.UserExamples;
import org.springframework.stereotype.Service;

@Service
public class LoanEngine {

    private int loanAmount;
    private double maxLoanAmount;
    private int loanPeriod;

    public LoanApplicationResult generateLoanApplicationResult(LoanApplication loanApplication) {

        long personalCode = loanApplication.getPersonalCode();
        loanAmount = loanApplication.getLoanAmount();
        loanPeriod = loanApplication.getLoanPeriod();

        User user = new UserExamples().getUserByPersonalCode(personalCode);

        if (user == null) {
            return new LoanApplicationResult(false, "Non existent Personal Code.");
        }
        if (user.getSegment() == 0) {
            return new LoanApplicationResult(false, "User is in debt.");
        }

        // If the max loan amount surpasses the requested amount, the max loan is returned with positive decision.
        // Else loan Period increases by 1 until it finds a suitable maxLoan bigger that requested Loan.
        double creditModifier = user.getCreditModifier();
        double originalMaxLoanAmount = (creditModifier * loanPeriod);
        maxLoanAmount = originalMaxLoanAmount;

        if (!obtainAcceptableMaxLoanAmount(creditModifier)) {
            return new LoanApplicationResult(false,
                    0, "No acceptable loan can be generated.");
        }

        originalMaxLoanAmount = putLoanInsideProperLimits(originalMaxLoanAmount);
        maxLoanAmount = putLoanInsideProperLimits(maxLoanAmount);

        return new LoanApplicationResult(true, (int) originalMaxLoanAmount, (int) maxLoanAmount, loanPeriod,
                "Suitable Loan Found", loanApplication);
    }

    public boolean obtainAcceptableMaxLoanAmount (double creditModifier){
        while (maxLoanAmount < loanAmount) {
            if (checkLoanPeriodIsOutsideProperLimits(loanPeriod)) {
                return false;
            }
            loanPeriod++;
            maxLoanAmount = (creditModifier * loanPeriod);
        }
        return true;
    }

    public double putLoanInsideProperLimits(double maxLoanAmount){
        maxLoanAmount = (maxLoanAmount < 2000) ? 0 : maxLoanAmount;
        maxLoanAmount = (Math.min(10000, maxLoanAmount));
        return maxLoanAmount;
    }

    public boolean checkLoanPeriodIsOutsideProperLimits (int loanPeriod) {
        return (loanPeriod >= 64);
    }
}

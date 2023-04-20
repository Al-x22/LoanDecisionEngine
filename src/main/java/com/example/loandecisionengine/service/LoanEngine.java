package com.example.loandecisionengine.service;

import com.example.loandecisionengine.entity.LoanApplication;
import com.example.loandecisionengine.entity.LoanApplicationResult;
import com.example.loandecisionengine.entity.User;
import com.example.loandecisionengine.repository.UserExamples;
import org.springframework.stereotype.Service;

@Service
public class LoanEngine {

    public LoanApplicationResult generateLoanApplicationResult(LoanApplication loanApplication) {

        long personalCode = loanApplication.getPersonalCode();
        int loanAmount = loanApplication.getLoanAmount();
        int loanPeriod = loanApplication.getLoanPeriod();

        User user = new UserExamples().getUserByPersonalCode(personalCode);

        if (user == null) {
            return new LoanApplicationResult(false, "Non existent Personal Code.");
        }
        if (user.getSegment() == 0) {
            return new LoanApplicationResult(false, "User is in debt.");
        }

        // By ordering the given algorithm, it is possible to obtain the max amount of money
        // that can be given in the loanPeriod. This is possible because the max amount of money that can be obtained
        // is given when the credit score is 1, or the closest to 1 as possible from positive numbers.
        // By replacing credit score for 1 in the algorithm and solving for the loanAmount we will get the maximum loan amount.

        // If the max loan amount surpasses the requested amount, the max loan is returned with positive decision.
        // Else loan Period increases by 1 until it finds a suitable maxLoan bigger that requested Loan.
        double creditModifier = user.getCreditModifier();
        double originalMaxLoanAmount = (creditModifier * loanPeriod);
        double maxLoanAmount = originalMaxLoanAmount;

        while (maxLoanAmount < loanAmount) {
            if (loanPeriod >= 64) {
                return new LoanApplicationResult(false,
                        0, "No acceptable loan can be generated.");
            }
            loanPeriod++;
            maxLoanAmount = (creditModifier * loanPeriod);
        }
        originalMaxLoanAmount = (originalMaxLoanAmount < 2000) ? 0 : originalMaxLoanAmount;
        originalMaxLoanAmount = (Math.min(10000, originalMaxLoanAmount));
        maxLoanAmount = (Math.min(10000, maxLoanAmount));

        return new LoanApplicationResult(true, (int) originalMaxLoanAmount, (int) maxLoanAmount, loanPeriod,
                "Suitable Loan Found", loanApplication);
    }
}

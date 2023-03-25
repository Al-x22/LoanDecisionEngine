package com.example.loandecisionengine.service;

import com.example.loandecisionengine.entity.LoanApplication;
import com.example.loandecisionengine.entity.LoanApplicationResult;
import com.example.loandecisionengine.entity.User;
import com.example.loandecisionengine.repository.UserExamples;
import org.springframework.stereotype.Service;

@Service
public class GenerateLoanApplicationResult {

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
        maxLoanAmount = (Math.min(10000, maxLoanAmount));

        return new LoanApplicationResult(true,(int) originalMaxLoanAmount, (int) maxLoanAmount, loanPeriod,
                "Suitable Loan Found", loanApplication);
    }
}

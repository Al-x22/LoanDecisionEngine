package com.example.loandecisionengine.service;

import com.example.loandecisionengine.entity.LoanApplication;
import com.example.loandecisionengine.entity.LoanApplicationResult;
import org.springframework.stereotype.Service;

@Service
public class GenerateLoanApplicationResult {

    public LoanApplicationResult generateLoanApplicationResult(LoanApplication loanApplication){
        // Add proper decision Engine
        return new LoanApplicationResult("positive", 20000);
    }

}

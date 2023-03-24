package com.example.loandecisionengine.controller;


import com.example.loandecisionengine.entity.LoanApplication;
import com.example.loandecisionengine.entity.LoanApplicationResult;
import com.example.loandecisionengine.service.GenerateLoanApplicationResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanApplicationController {

    @GetMapping("/loan")
    public String showForm(Model model) {
        model.addAttribute("loanApplication", new LoanApplication());
        return "loanApplicationForm";
    }
    @PostMapping("/loan")
    public String processForm(@ModelAttribute LoanApplication loanApplication, Model model) {
        LoanApplicationResult loanApplicationResult =
                new GenerateLoanApplicationResult().generateLoanApplicationResult(loanApplication);
        model.addAttribute("loanApplicationResult", loanApplicationResult);
        return "loanApplicationForm";
    }
}

package com.example.loandecisionengine.controller;

import com.example.loandecisionengine.entity.LoanApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanApplicationController {

    @GetMapping("/loan")
    public String showForm(Model model) {
        model.addAttribute("loanApplication", new LoanApplication());
        return "loanApplicationForm";
    }
}

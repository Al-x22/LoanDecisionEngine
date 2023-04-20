package com.example.loandecisionengine.Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoanPage {
    SelenideElement header = $("#header");

    public String getHeader() {return header.getText();};
}

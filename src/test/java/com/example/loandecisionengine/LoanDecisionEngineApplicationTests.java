package com.example.loandecisionengine;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.example.loandecisionengine.Page.LoanPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class LoanDecisionEngineApplicationTests {

    @BeforeAll
    public static void configureSelenide() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "http://localhost:8080";
    }
    @BeforeEach
    public void openLoginPage() {
        open("/loan");
    }
    @Test
    public void givenCorrectLink_CorrectHeaderIsShown() {
        LoanPage loanPage = new LoanPage();
        assertThat(loanPage.getHeader()).isEqualTo("Loan Application");

    }

}

package com.kochetkov;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Search repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Moving to repository {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Open Issues")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Checking for availability Issue with number {number}")
    public void checkForAvailableIssueWithNumber(int number) {
        $(byText("#" + number)).should(Condition.visible);
    }
}

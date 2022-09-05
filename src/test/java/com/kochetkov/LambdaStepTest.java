package com.kochetkov;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    public final static String REPOSITORY = "IlyaKoch/allure-reports";
    public final static Integer ISSUE_NUMBER = 12;

    @Test
    public void testGitHub() {
        step("Open start page", () ->  {
            open("https://github.com/");
        });

        step("Search repository " + REPOSITORY, () -> {
                    $(".header-search-input").click();
                    $(".header-search-input").sendKeys(REPOSITORY);
                    $(".header-search-input").submit();
                });
        step("Moving to repository " + REPOSITORY, () -> {
                    $(linkText(REPOSITORY)).click();
                });
        step("Open Issues ", () -> {
                    $(partialLinkText("Issues")).click();
                });
        step("Checking for availability Issue with number" + ISSUE_NUMBER, () -> {
            $(byText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}

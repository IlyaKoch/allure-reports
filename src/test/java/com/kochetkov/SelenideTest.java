package com.kochetkov;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    public void testGitHub() {
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("IlyaKoch/allure-reports");
        $(".header-search-input").submit();

        $(linkText("IlyaKoch/allure-reports")).click();
        $(partialLinkText("Issues")).click();
        $(byText("#12")).should(Condition.visible);
    }
}

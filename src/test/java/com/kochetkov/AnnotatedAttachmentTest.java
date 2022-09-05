package com.kochetkov;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AnnotatedAttachmentTest {

    public final static String REPOSITORY = "IlyaKoch/allure-reports";
    public final static Integer ISSUE_NUMBER = 12;

    @Test
    public void testGitHub() {
        step("Open start page", () -> {
            open("https://github.com/");
            takeScreenshot();
            takePageSource();
        });
        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            takeScreenshot();
            takePageSource();
        });
        step("Moving to repository " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
            takeScreenshot();
            takePageSource();
        });
        step("Open Issues ", () -> {
            $(partialLinkText("Issues")).click();
            takeScreenshot();
            takePageSource();
        });
        step("Checking for availability Issue with number" + ISSUE_NUMBER, () -> {
            $(byText("#" + ISSUE_NUMBER)).should(Condition.visible);
            takeScreenshot();
        });
    }

    @Attachment(value = "Page Source", type = "text/html")
    public byte[] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
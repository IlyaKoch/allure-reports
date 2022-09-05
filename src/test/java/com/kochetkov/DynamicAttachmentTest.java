package com.kochetkov;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

public class DynamicAttachmentTest {

    @Test
    public void testGitHub() {
        step("Open start page", () -> {
            open("https://github.com/");
            addAttachment("Hello", "World!");
        });
    }
}

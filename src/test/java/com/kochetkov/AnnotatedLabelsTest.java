package com.kochetkov;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Issue")
@Owner("IlyaKoch")
public class AnnotatedLabelsTest {

    @Test
    @Story("Поиск по Issue")
    @Link(name = "Главная страница", url = "https://github.com")
    @DisplayName("Проверка того, что мы можем поискать конкретную Issue")
    @Severity(SeverityLevel.BLOCKER)
    public void testGitHub() {
        step("Open start page", () ->  {
            open("https://github.com/");
        });
    }
}
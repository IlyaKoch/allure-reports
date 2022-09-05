package com.kochetkov;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Feature("Issue")
@Owner("IlyaKoch")
public class RegionsTest {

    @ParameterizedTest
    @ValueSource(strings = {"Москва", "Санкт-Петербург"})
    public void testGitHub(String region) {
        parameter("Region", region);
        step("Open start page in region " + region, () ->  {
            open("https://github.com/");
        });
    }
}
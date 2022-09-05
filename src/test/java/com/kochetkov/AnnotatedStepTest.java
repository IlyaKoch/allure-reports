package com.kochetkov;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    public final static String REPOSITORY = "IlyaKoch/allure-reports";
    public final static Integer ISSUE_NUMBER = 12;

    @Test
    public void testGitHub() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.checkForAvailableIssueWithNumber(ISSUE_NUMBER);
    }
}
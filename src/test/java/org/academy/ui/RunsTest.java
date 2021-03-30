package org.academy.ui;

import org.academy.ui.pages.MainPage;
import org.academy.ui.pages.RunsPage;
import org.academy.ui.steps.LoginSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunsTest extends BaseTest{

    private LoginSteps loginSteps = new LoginSteps();
    private MainPage mainPage;
    private RunsPage runsPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        mainPage = loginSteps.makeLogin();
    }

    @Test
    public void checkTestRun() throws InterruptedException {
        runsPage = mainPage
                .scrollToProject()
                .clickOnProjectLnk()
                .clickOnTestCases()
                .clickOnRunTest()
                .scrollToButton()
                .clickOnAddTestRun();

    }
}
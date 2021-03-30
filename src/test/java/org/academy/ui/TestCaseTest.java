package org.academy.ui;

import org.academy.ui.pages.MainPage;
import org.academy.ui.steps.LoginSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    private final LoginSteps loginSteps = new LoginSteps();
    private MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        mainPage = loginSteps.makeLogin();
    }

    @Test
    public void addTestCaseTest() throws InterruptedException {
        mainPage.clickOnProject()
                .clickOnTestCaseLink()
                .clickOnAddTestCaseBtn()
                .fillTitleField("Test case Test")
                .scrollToAcceptBtn()
                .clickOnAcceptBtn();
    }
}

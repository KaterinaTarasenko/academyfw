package org.academy.ui;

import org.academy.ui.pages.SuitePage;
import org.academy.ui.pages.MainPage;
import org.academy.ui.steps.LoginSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class SuiteTest extends BaseTest {
    private final int id = ++count;
    private static int count = 0;
    private final String suiteName = "Suite " + id;
    private final String suiteDescription = "Ceated on " + LocalDateTime.now();
    private final LoginSteps loginSteps = new LoginSteps();
    private MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        mainPage = loginSteps.makeLogin();
    }

    @Test
    public void addSuiteTest() {
        SuitePage suitePage = mainPage
                .clickOnProjectLink()
                .clickOnTestCasesLink()
                .clickOnAddSectionBtn()
                .fillNameField(suiteName)
                .fillDescriptionField(suiteDescription)
                .clickOnAcceptBtn();
    }
}

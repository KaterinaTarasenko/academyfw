package org.academy.ui;

import org.academy.ui.pages.MainPage;
import org.academy.ui.steps.LoginSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {
    LoginSteps loginSteps = new LoginSteps();
    MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        mainPage = loginSteps.makeLogin();
    }

    @Test
    public void addProjectTest() {
        mainPage.clickOnAddProjectBtn()
                .fillNameField(getProjectName())
                .fillAnnouncementField(getProjectAnnouncement())
                .clickOnAcceptBtn();
    }
}

package org.academy.ui;

import org.academy.ui.pages.MainPage;
import org.academy.ui.steps.LoginSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddMilestoneTest extends BaseTest {
    LoginSteps loginSteps = new LoginSteps();
    MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        mainPage = loginSteps.makeLogin();
    }

    @Test
    public void addMilestoneTest() {
        mainPage
                .clickOnTestProject()
                .clickOnAddMilestoneBtn()
                .fillMilestoneNameField(getMilestoneName())
                .fillMilestoneReferenceField(getMilestoneReference())
                .fillMilestoneDescriptionField(getMilestoneDescription())
                .clickOnStartDate()
                .chooseAndClickOnStartDate()
                .clickOnEndDate()
                .chooseAndClickOnEndDate()
                .clickOnMilestoneAcceptBtn();
    }
}

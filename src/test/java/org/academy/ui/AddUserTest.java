package org.academy.ui;

import org.academy.ui.pages.AddUserPage;
import org.academy.ui.pages.MainPage;
import org.academy.ui.steps.LoginSteps;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddUserTest extends BaseTest {
    LoginSteps loginSteps = new LoginSteps();
    MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        mainPage = loginSteps.makeLogin();
    }

    @Test
    public void addUserTest() throws InterruptedException {
        AddUserPage addUserPage = mainPage.clickOnAdministrationLink()
                                          .clickOnUsersBtn()
                                          .clickOnAddUserBtn()
                                          .fillFullNameField(getFullName())
                                          .fillEmailField(getEmail());

        addUserPage.scrollToElement(webDriver, webDriver.findElement(By.id("accept")));
        addUserPage.clickOnAcceptUserBtn();
    }
}


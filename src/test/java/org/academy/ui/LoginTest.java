package org.academy.ui;

import org.academy.ui.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        loginPage = new LoginPage(true, getAccountUrl());
    }

    @Test
    public void positiveLoginTest() {
        loginPage
                .fillLoginField(getEmail())
                .fillPassField(getPassword())
                .clickOnLoginButton();
    }

    @Test
    public void logoutTest() {
        loginPage
                .fillLoginField(getEmail())
                .fillPassField(getPassword())
                .clickOnLoginButton()
                .clickOnMyUsername()
                .clickOnLogout();
    }

}

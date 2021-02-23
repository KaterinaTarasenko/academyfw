package org.academy.ui.steps;

import lombok.extern.slf4j.Slf4j;
import org.academy.ui.pages.LoginPage;
import org.academy.ui.pages.MainPage;

@Slf4j
public class LoginSteps extends Steps {
    private MainPage mainPage;

    public MainPage makeLogin() {
        if (mainPage == null)
            mainPage = new LoginPage(true, getAccountUrl())
                    .fillLoginField(getEmail())
                    .fillPassField(getPassword())
                    .clickOnLoginButton();
        return mainPage;
    }
}

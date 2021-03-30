package org.academy.ui.pages;

import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {
    public LoginPage() {
        super();
    }

    public LoginPage(boolean navigate, String navigateToUrl) {
        super(navigate, navigateToUrl);
    }

    private static final By loginField = By.xpath("//input[@id='name']");
    private static final By passwordField = By.xpath("//input[@id='password']");
    private static final By loginButton = By.xpath("//button[@id='button_primary']");

    public LoginPage fillLoginField(String login) {
        findElement(loginField).sendKeys(login);
        return this;
    }

    public LoginPage fillPassField(String pass) {
        findElement(passwordField).sendKeys(pass);
        return this;
    }

    public MainPage clickOnLoginButton() {
        waitUntilElementIsClickable(loginButton).click();
        return new MainPage();
    }

//    public MainPage login() {
//        loginField.sendKeys(WebConfig.getLogin());
//        passField.sendKeys(WebConfig.getPassword());
//        submitForm.click();
//        return new MainPage();
//    }


}
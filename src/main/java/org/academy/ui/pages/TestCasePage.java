package org.academy.ui.pages;

import org.openqa.selenium.By;

public class TestCasePage extends AbstractPage {
    public TestCasePage() {
        super();
    }

    public TestCasePage(boolean navigate, String navigateToUrl) {
        super(navigate, navigateToUrl);
    }

    private static final By titleField = By.xpath("//input[@id='title']");
    private static final By acceptBtn = By.xpath("//button[@id='accept']");
    private static final By testCaseLink = By.xpath("//a[@id='navigation-suites']");
    private static final By addTestCaseBtn = By.xpath("//a[@id='sidebar-cases-add']");

    public TestCasePage clickOnTestCaseLink() {
        waitUntilElementIsClickable(testCaseLink).click();
        return this;
    }
    public TestCasePage clickOnAddTestCaseBtn() {
        waitUntilElementIsClickable(addTestCaseBtn).click();
        return this;
    }

    public TestCasePage fillTitleField(String sectionName) {
        findElement(titleField).sendKeys(sectionName);
        return this;
    }

    public TestCasePage scrollToAcceptBtn() throws InterruptedException {
        scrollToElement(webDriver, webDriver.findElement(acceptBtn));
        return this;
    }

    public TestCasePage clickOnAcceptBtn() {
        waitUntilElementIsClickable(acceptBtn).click();
        return this;
    }
}

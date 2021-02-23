package org.academy.ui.pages;

import org.openqa.selenium.By;

public class RunsPage extends AbstractPage {
    public RunsPage() {
        super();
    }

    public RunsPage(boolean navigate, String navigateToUrl) {
        super(navigate, navigateToUrl);
    }

    private static final By project = By.xpath("//a[@href='index.php?/projects/overview/20'][contains(.,'TestProject')]");
    private static final By testCases = By.xpath("//a[contains(@id,'sidebar-cases-overview')]");
    private static final By runTestBtn = By.xpath("//span[@class='button-text'][contains(.,'Run Test')]");
    private static final By addTestRunBtn = By.xpath("//button[contains(@id,'accept')]");

    public RunsPage clickOnTestCases() {
        waitUntilElementIsClickable(testCases)
                .click();
        return this;
    }

    public RunsPage clickOnRunTest() {
        waitUntilElementIsClickable(runTestBtn)
                .click();
        return this;
    }

    public RunsPage scrollToButton() throws InterruptedException {
        scrollToElement(webDriver, webDriver.findElement(addTestRunBtn));
        return this;

    }
    public RunsPage clickOnAddTestRun(){
        waitUntilElementIsClickable(addTestRunBtn)
                .click();
        return this;
    }
}

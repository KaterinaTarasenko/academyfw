package org.academy.ui.pages;

import org.openqa.selenium.By;

public class SuitePage extends AbstractPage {
    public SuitePage() {
        super();
    }

    public SuitePage(boolean navigate, String navigateToUrl) {
        super(navigate, navigateToUrl);
    }

    private static final By nameField = By.xpath("//input[@id='editSectionName']");
    private static final By descriptionField = By.xpath("//textarea[@id='editSectionDescription']");
    private static final By acceptBtn = By.xpath("//span[@class='editSectionAdd']");
    private static final By testCasesLink = By.xpath("//a[@id='navigation-suites']");
    private static final By addSectionBtn = By.xpath("//a[@id='addSectionInline']");
    private static final By addSectionLink = By.xpath("//a[@id='addSection']");

    public SuitePage clickOnTestCasesLink() {
        waitUntilElementIsClickable(testCasesLink).click();
        return this;
    }

    public SuitePage clickOnAddSectionBtn() {
        if (webDriver.findElement(addSectionBtn).isDisplayed())
            waitUntilElementIsClickable(addSectionBtn).click();
        else
            waitUntilElementIsClickable(addSectionLink).click();
        return this;
    }


    public SuitePage fillNameField(String sectionName) {
        findElement(nameField).sendKeys(sectionName);
        return this;
    }

    public SuitePage fillDescriptionField(String sectionDescription) {
        findElement(descriptionField).sendKeys(sectionDescription);
        return this;
    }

    public SuitePage clickOnAcceptBtn() {
        waitUntilElementIsClickable(acceptBtn).click();
        return this;
    }
}

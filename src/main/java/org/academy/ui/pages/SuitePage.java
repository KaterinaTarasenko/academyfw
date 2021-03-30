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
    private static final By newCaseLink = By.xpath("//tr[@id='row-9']//td//a[@rel='keep-get']//span[@class='title'][contains(text(),'New Test')]");
    private static final By createdBy = By.xpath("//td[@class='noborder nopad-top'][contains(text(),'ssacd5 ssacd5')]");
    private static final By priority = By.xpath("//td[@id='cell_priority_id']");

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

    public SuitePage clickOnNewTestLink() {
        waitUntilElementIsClickable(newCaseLink).click();
        return this;
    }

    public String getPageTitle() {
        return this.webDriver.getTitle();
    }

    public String getAuthor() {
        return this.webDriver.findElement(createdBy).getText();
    }

    public String getPriority() {
        return this.webDriver.findElement(priority).getText();
    }
}

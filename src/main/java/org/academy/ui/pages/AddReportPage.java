package org.academy.ui.pages;

import org.openqa.selenium.By;

public class AddReportPage extends AbstractPage {
    public AddReportPage() {
        super();
    }

    public AddReportPage(boolean navigateToPage, String navigateToPageUrl) {
        super(navigateToPage, navigateToPageUrl);
    }

    private static final By reportsLink = By.xpath("//a[@id='navigation-reports']");
    private static final By summaryForCasesLink = By.xpath("//body[1]/div[4]/div[1]/div[5]/div[1]/div[5]/table[1]/tbody[1]/tr[2]/td[2]/a[1]");
    private static final By descriptionField = By.xpath("//textarea[@id='description']");
    private static final By customRunsSelected = By.xpath("//input[@id='custom_runs_include_selected']");
    private static final By addTestRunsBtn = By.xpath("//a[@id='custom_runs_add']");
    private static final By selectAllRunsBtn = By.xpath("//a[contains(text(),'All')]");
    private static final By addRunsSubmitBtn = By.xpath("//button[@id='addRunsSubmit']");
    private static final By addReportBtn = By.xpath("//button[@id='submit']");

    public AddReportPage clickOnReportsLink(){
        waitUntilElementIsClickable(reportsLink).click();
        return this;
    }

    public AddReportPage clickAddSummaryForCasesLink(){
        waitUntilElementIsClickable(summaryForCasesLink).click();
        return this;
    }

    public AddReportPage fillDescriptionField(String description){
        findElement(descriptionField).sendKeys(description);
        return this;
    }

    public AddReportPage customRunsSelecting(){
        waitUntilElementIsClickable(customRunsSelected).click();
        waitUntilElementIsClickable(addTestRunsBtn).click();
        return this;
    }

    public AddReportPage selectAllRuns(){
        waitUntilElementIsClickable(selectAllRunsBtn).click();
        waitUntilElementIsClickable(addRunsSubmitBtn).click();
        return this;
    }

    public AddReportPage clickAddReportBtn(){
        waitUntilElementIsClickable(addReportBtn).click();
        return this;
    }
}

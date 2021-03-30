package org.academy.ui.pages;

import org.academy.ui.pages.administration.AdministrationPage;
import org.academy.ui.pages.project.EditProjectPage;
import org.openqa.selenium.By;

public class MilestonePage extends AdministrationPage {
    public MilestonePage() {
        super();
    }

    public MilestonePage(boolean navigateToPage, String navigateToPageUrl) {
        super(navigateToPage, navigateToPageUrl);
    }

    private static final By milestonesLink = By.xpath("//a[@id='navigation-milestones']");
    private static final By addMilestoneLink = By.xpath("//a[contains(text(),'Add Milestone')]");
    private static final By nameOfMilestoneField = By.xpath("//input[@id='name']");
    private static final By descriptionField = By.xpath("//textarea[@id='description']");
    private static final By editMilestoneLink = By.xpath("//a[contains(text(),'Edit')]");
    private static final By saveButton = By.xpath("//button[@id='accept']");

//    public MilestonePage clickOnMilestonesOfProject(String projectName){
//        //waitUntilElementIsClickable(By.xpath("//a[contains(.,'" + projectName + "')]")).click();
//        waitUntilElementIsClickable(milestonesLink).click();
//        return this;
//    }

    public MilestonePage clickOnAddMilestone() {
        waitUntilElementIsClickable(addMilestoneLink).click();
        return this;
    }
    public MilestonePage editMilestonePage(String milestoneName) {
        waitUntilElementIsClickable(By.xpath("//a[contains(.,'" + milestoneName + "')]")).click();
        return this;
    }

    public  MilestonePage clickEditBtn() {
        waitUntilElementIsClickable(editMilestoneLink).click();
        return this;
    }

    public MilestonePage fillDescriptionField(String description) {
        findElement(descriptionField).sendKeys(description);
        return this;
    }

    public MilestonePage clickOnAcceptBtn() {
        waitUntilElementIsClickable(saveButton).click();
        return this;
    }
}

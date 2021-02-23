package org.academy.ui.pages;

import org.academy.ui.pages.administration.ProjectsPage;
import org.academy.ui.pages.project.TestSuite;
import org.openqa.selenium.By;

public class AddProjectPage extends AbstractPage {
    public AddProjectPage() {
        super();
    }

    public AddProjectPage(boolean navigate, String navigateToUrl) {
        super(navigate, navigateToUrl);
    }

    protected static final By nameField = By.xpath("//input[@id='name']");
    protected static final By announcementField = By.xpath("//textarea[@id='announcement']");

    private static final By singleAllCasesRadioBtn = By.xpath("//input[@id='suite_mode_single']");
    private static final By singleBaseLineRadioBtn = By.xpath("//input[@id='suite_mode_single_baseline']");
    private static final By multipleTestRadioBtn = By.xpath("//input[@id='suite_mode_multi']");

    private static final By acceptBtn = By.xpath("//button[@id='accept']");

    public AddProjectPage fillNameField(String projectName) {
        findElement(nameField).sendKeys(projectName);
        return this;
    }

    public AddProjectPage fillAnnouncementField(String projectAnnouncement) {
        findElement(announcementField).sendKeys(projectAnnouncement);
        return this;
    }

    public AddProjectPage chooseTestSuite(TestSuite suite) {
        switch (suite) {
            case SINGLEALLCASES:
                findElement(singleAllCasesRadioBtn).click();
                break;
            case SINGLEBASELINE:
                findElement(singleBaseLineRadioBtn).click();
                break;
            case MULTIPLE:
                findElement(multipleTestRadioBtn).click();
        }
        return this;
    }

    public ProjectsPage clickOnAcceptBtn() {
        scrollToElement(webDriver, webDriver.findElement(acceptBtn));
        waitUntilElementIsClickable(acceptBtn).click();
        return new ProjectsPage();
    }
}

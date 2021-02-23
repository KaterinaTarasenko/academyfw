package org.academy.ui.pages;

import org.academy.ui.pages.administration.OverviewPage;
import org.openqa.selenium.By;

public class MainPage extends AbstractPage {

    public MainPage() {
        super();
    }

    public MainPage(boolean navigateToPage, String navigationUrl) {
        super(navigateToPage, navigationUrl);
    }

    private static final By usernameLink = By.xpath("//span[@class='navigation-username']");
    private static final By logout = By.xpath("//a[@id='navigation-user-logout']");
    private static final By addProjectBtn = By.xpath("//a[@id='sidebar-projects-add']");
    private static final By administrationLink = By.xpath("//a[@id='navigation-admin']");
    private static final By projectLink = By.xpath("//a[contains(text(),'UI Suite Tests')]");
    private static final By navigationUser = By.xpath("//a[@id='navigation-user']//span[@class='caret']");
    private static final By navigationUserSettings = By.xpath("//a[@id='navigation-user-settings']");
    private static final By project = By.xpath("//a[@href='index.php?/projects/overview/20'][contains(.,'TestProject')]");

    public MainPage clickOnMyUsername() {
        waitUntilElementIsClickable(usernameLink).click();
        return this;
    }

    public MainPage clickOnLogout() {
        waitUntilElementIsClickable(logout).click();
        return this;
    }

    public AddProjectPage clickOnAddProjectBtn() {
        waitUntilElementIsClickable(addProjectBtn).click();
        return new AddProjectPage();
    }

    public OverviewPage clickOnAdministrationLink() {
        waitUntilElementIsClickable(administrationLink).click();
        return new OverviewPage();
    }

    public SuitePage clickOnProjectLink() {
        if (webDriver.findElement(projectLink).isDisplayed()) {
            waitUntilElementIsClickable(projectLink).click();
        } else {
            System.err.println("Project 'UI Suite Tests' not found");
            System.out.println("Creating new project...");
            waitUntilElementIsClickable(addProjectBtn).click();
            webDriver.findElement(By.xpath("//input[@id='name']")).sendKeys("UI Suite Tests");
            webDriver.findElement(By.xpath("//button[@id='accept']")).click();
            System.out.println("Project 'UI Suite Tests' created");
            webDriver.findElement(By.xpath("//a[@id='navigation-dashboard']")).click();
            waitUntilElementIsClickable(projectLink).click();
        }
        return new SuitePage();
    }

    public TestCasePage clickOnProject() {
        waitUntilElementIsClickable(projectLink).click();
        return  new TestCasePage();
    }

    public AddMilestonePage clickOnTestProject() {
        waitUntilElementIsClickable(projectLink).click();
        return new AddMilestonePage();
    }

    public MainPage clcikOnNavigationUser() {
        waitUntilElementIsClickable(navigationUser).click();
        return new MainPage();
    }

    public SettingsPage clickOnNavigationUserSettings() {
        waitUntilElementIsClickable(navigationUserSettings).click();
        return new SettingsPage();
    }
    public MainPage scrollToProject() {
        scrollToElement(webDriver, webDriver.findElement(project));
        return this;
    }
    public RunsPage clickOnProjectLnk(){
        waitUntilElementIsClickable(project)
                .click();
        return new RunsPage();
    }
}


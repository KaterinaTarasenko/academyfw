package org.academy.ui.pages.administration;

import org.academy.ui.pages.AbstractPage;
import org.academy.ui.pages.MainPage;
import org.openqa.selenium.By;

public abstract class AdministrationPage extends AbstractPage {
    public AdministrationPage() {
        super();
    }

    public AdministrationPage(boolean navigate, String navigateToUrl) {
        super(navigate, navigateToUrl);
    }

    private static final By overview = By.xpath("//a[@id='navigation-sub-overview']");
    private static final By projects = By.xpath("//a[@id='navigation-sub-projects']");
    private static final By usersAndRoles = By.xpath("//a[@id='navigation-sub-users']");
    private static final By customization = By.xpath("//a[@id='navigation-sub-customization']");
    private static final By integration = By.xpath("//a[@id='navigation-sub-integration']");
    private static final By dataManagement = By.xpath("//a[@id='navigation-sub-subscription']");
    private static final By siteSettings = By.xpath("//a[@id='navigation-sub-sitesettings']");

    private static final By dashboard = By.xpath("//a[@href='index.php?/dashboard']");

    public OverviewPage clickOnOverviewBtn() {
        waitUntilElementIsClickable(overview).click();
        return new OverviewPage();
    }

    public ProjectsPage clickOnProjectsBtn() {
        waitUntilElementIsClickable(projects).click();
        return new ProjectsPage();
    }

    public UsersAndRolesPage clickOnUsersBtn() {
        waitUntilElementIsClickable(usersAndRoles).click();
        return new UsersAndRolesPage();
    }

    public MainPage clickOnDashboardBtn() {
        waitUntilElementIsClickable(dashboard).click();
        return new MainPage();
    }
}
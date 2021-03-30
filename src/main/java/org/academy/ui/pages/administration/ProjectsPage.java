package org.academy.ui.pages.administration;

import org.academy.ui.pages.AddProjectPage;
import org.academy.ui.pages.MainPage;
import org.academy.ui.pages.MilestonePage;
import org.academy.ui.pages.project.EditProjectPage;
import org.openqa.selenium.By;

public class ProjectsPage extends AdministrationPage {
    private static final By addProjectBtn = By.xpath("//a[@href='index.php?/admin/projects/add']");

    private static final By confirmText = By.xpath("//strong[contains(.,'Yes, delete this project (cannot be undone)')]");
    private static final By okButton = By.xpath("(//a[contains(.,'OK')])[3]");

    private static final By milestonesLink = By.xpath("//a[@id='navigation-milestones']");
    private static final By dashboardLink = By.xpath("//a[@id='navigation-dashboard']");

    public ProjectsPage() {
        super();
    }

    public ProjectsPage(boolean navigate, String navigateToUrl) {
        super(navigate, navigateToUrl);
    }

    public ProjectsPage clickRemoveBtn(String projectName) {
        String sb = "//a[contains(@onclick,'" + projectName.trim() + "')]";
        waitUntilElementIsClickable(By.xpath(sb)).click();

        return this;
    }

    public EditProjectPage clickOnProjectPage(String projectName) {
        waitUntilElementIsClickable(By.xpath("//a[contains(.,'" + projectName + "')]")).click();
        return new EditProjectPage();
    }

    public ProjectsPage clickOnCheckbox() {
        waitUntilElementIsPresent(confirmText).click();
        return this;
    }

    public ProjectsPage clickOnOkBtn() {
        waitUntilElementIsPresent(okButton).click();
        return this;
    }

    public AddProjectPage clickOnAddProjectBtn() {
        waitUntilElementIsClickable(addProjectBtn).click();
        return new AddProjectPage();
    }

    public MilestonePage clickOnMilestonesOfProject(String projectName){
        waitUntilElementIsClickable(By.xpath("//a[contains(.,'" + projectName + "')]")).click();
        waitUntilElementIsClickable(milestonesLink).click();
        return new MilestonePage();
    }

    public MainPage goToDashboard() {
        waitUntilElementIsClickable(dashboardLink).click();
        return new MainPage();
    }
}

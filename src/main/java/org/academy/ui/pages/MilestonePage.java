package org.academy.ui.pages;

import org.openqa.selenium.By;

public class MilestonePage extends AbstractPage {
    public MilestonePage() {
        super();
    }

    public MilestonePage(boolean navigateToPage, String navigateToPageUrl) {
        super(navigateToPage, navigateToPageUrl);
    }

    private static final By milestonesLink = By.xpath("//a[@id='navigation-milestones']");

    public MilestonePage clickOnMilestones(){
        waitUntilElementIsClickable(milestonesLink).click();
        return this;
    }
}

package org.academy.api.end2end;

import org.academy.api.requests.MilestoneRequests;
import org.academy.ui.BaseTest;
import org.academy.ui.pages.MainPage;
import org.academy.ui.pages.RunsPage;
import org.academy.ui.steps.LoginSteps;
import org.academy.utils.helpers.ApiHelpers;
import org.academy.utils.helpers.DataRandomizer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class MilestoneEndToEnd extends BaseTest {
    protected ApiHelpers apiHelpers = new ApiHelpers();
    protected DataRandomizer dr = new DataRandomizer();

    private LoginSteps loginSteps = new LoginSteps();
    private MainPage mainPage;

    private final MilestoneRequests milestoneRequests = new MilestoneRequests();

    @BeforeMethod(alwaysRun = true)

    public void precondition() {
        mainPage = loginSteps.makeLogin();
    }

    @Test
    public void addMilestoneCase() {
        String milestoneName = "Release_".concat(apiHelpers.getCurrentTimestamp());
        String description = "Some description for release";

        Map<String, Object> attributes = milestoneRequests.addMilestoneRequest(milestoneName, description);

        mainPage.clickOnMilestonePage().clickOnMilestones();
    }
}

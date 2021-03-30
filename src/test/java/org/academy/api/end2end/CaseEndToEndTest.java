package org.academy.api.end2end;

import org.academy.api.requests.CasesRequests;
import org.academy.ui.pages.MainPage;
import org.academy.ui.pages.SuitePage;
import org.academy.ui.steps.LoginSteps;

import org.awaitility.Awaitility;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CaseEndToEndTest {
    private final CasesRequests requests = new CasesRequests();
    private final LoginSteps loginSteps = new LoginSteps();
    private MainPage mainPage;
    private SuitePage page = new SuitePage();

    @Test
    public void test() {
        String caseTitle = "New Test";
        String expectedPageTitle = caseTitle + " - TestRail";
        String expectedPriority = "Priority\nMedium";
        String expectedCreatedBy = "ssacd5 ssacd5";
        int expectedPriorityId = 2;

        Map<String,Object> newCase = requests.createCaseRequest(caseTitle);
//        Awaitility.waitAtMost(Duration.ofSeconds(10));
//        String caseName = (String) newCase.get("title");
//        int caseId = (int) newCase.get("id");
//        int sectionId = (int) newCase.get("sectionId");
//        int priorityId = (int) newCase.get("priorityId");

        mainPage = loginSteps.makeLogin();
        page = mainPage
                .clickOnProjectLink()
                .clickOnTestCasesLink()
                .clickOnNewTestLink();
        assertThat(page.getPageTitle()).isEqualTo(expectedPageTitle).as("Error in title!");
        assertThat(page.getAuthor()).hasToString(expectedCreatedBy).as("Error in author!");
        assertThat(page.getPriority()).hasToString(expectedPriority).as("Error in priority!");
//        assertThat(priorityId).isEqualTo(expectedPriorityId).as("Error in priority id!");
    }
}

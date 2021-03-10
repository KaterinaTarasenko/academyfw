package org.academy.api;

import lombok.extern.slf4j.Slf4j;
import org.academy.api.requests.CasesRequests;
import org.testng.annotations.Test;

import java.util.*;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class CasesTest extends BaseTest {
    private final CasesRequests casesRequests = new CasesRequests();

    @Test
    public void getCaseTitle() {
        String casesTitle = casesRequests.getCaseRequest().getOrDefault("title", "null").toString();
        assertThat(casesTitle).isEqualTo("CgetId()").as("Case title need to be " + casesTitle);
    }

    @Test
    public void getAllCases() {
        Map<String,Object> allCases = casesRequests.getAllCasesRequest();
        List<String> caseTitles = new ArrayList<>();
        for (String value : allCases.keySet()) {
            caseTitles.add(value);
        }
        assertThat(caseTitles.size()).isEqualTo(allCases.size());
    }

    @Test
    public void addCase() {
        String caseName = "C".concat("getId()");
        String caseNameResponse = String.valueOf(casesRequests.createCaseRequest(caseName).get("title"));
        assertThat(caseNameResponse).isEqualTo(caseName).as("Case name expected: " + caseName);
    }
}

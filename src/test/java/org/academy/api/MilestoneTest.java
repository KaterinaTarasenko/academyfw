package org.academy.api;

import org.academy.api.requests.MilestoneRequests;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MilestoneTest extends BaseTest {
    private final MilestoneRequests milestoneRequests = new MilestoneRequests();

    @Test
    public void addMilestoneCase() {
        String milestoneName = "Release_".concat(apiHelpers.getCurrentTimestamp());
        String description = "Some description for release";

        Map<String, Object> attributes = milestoneRequests.addMilestoneRequest(milestoneName, description);
        assertThat(String.valueOf(attributes.get("name"))).isEqualTo(milestoneName).as("name should be:" + milestoneName);
        assertThat(String.valueOf(attributes.get("description"))).isEqualTo(description).as("desription should be:" + description);

    }

    @Test
    public void updateMilestoneCase() {
        String milestoneName = "Updated_name_".concat(apiHelpers.getCurrentTimestamp());
        String description = "Updated_description_".concat(apiHelpers.getCurrentTimestamp());
        boolean isCompleted = true;

        Map<String, Object> attributes = milestoneRequests.updateMilestoneWithCompleteResource("2", milestoneName, description, isCompleted);
        assertThat(String.valueOf(attributes.get("name"))).isEqualTo(milestoneName).as("name should be:" + milestoneName);
        assertThat(String.valueOf(attributes.get("description"))).isEqualTo(description).as("description should be:" + description);
        assertThat(String.valueOf(attributes.get("is_completed"))).isEqualTo("true").as("isCompleted should be:" + isCompleted);
    }
}

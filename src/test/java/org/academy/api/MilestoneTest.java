package org.academy.api;

import org.academy.api.requests.MilestoneRequests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MilestoneTest extends BaseTest {
    private final MilestoneRequests milestoneRequests = new MilestoneRequests();

    @Test
    public void getAllMilestones(){
        String projectId = "40";
        Map<String, Object> allMilestones = milestoneRequests.getAllMilestonesRequest(projectId);
        List<String> milestoneTitles = new ArrayList<>();
        for (String value : allMilestones.keySet()) {
            milestoneTitles.add(value);
        }
        assertThat(milestoneTitles.size()).isEqualTo(allMilestones.size());
    }

    @Test
    public void addMilestoneWithoutDescriptionCase() {
        String projectId = "40";
        String milestoneName = "Release_".concat(apiHelpers.getCurrentTimestamp());

        Map<String, Object> attributes = milestoneRequests.addMilestoneRequest(projectId, milestoneName);
        assertThat(String.valueOf(attributes.get("name"))).isEqualTo(milestoneName).as("name should be:" + milestoneName);

    }


//    @Test
//    public void updateMilestoneCase() {
//        String milestoneName = "Updated_name_".concat(apiHelpers.getCurrentTimestamp());
//        String description = "Updated_description_".concat(apiHelpers.getCurrentTimestamp());
//        boolean isCompleted = true;
//
//        Map<String, Object> attributes = milestoneRequests.updateMilestoneWithCompleteResource("2", milestoneName, description, isCompleted);
//        assertThat(String.valueOf(attributes.get("name"))).isEqualTo(milestoneName).as("name should be:" + milestoneName);
//        assertThat(String.valueOf(attributes.get("description"))).isEqualTo(description).as("description should be:" + description);
//        assertThat(String.valueOf(attributes.get("is_completed"))).isEqualTo("true").as("isCompleted should be:" + isCompleted);
//    }
}

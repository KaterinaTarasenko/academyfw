package org.academy.api;

import org.academy.api.requests.MilestoneRequests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MilestoneTest extends BaseTest {
    private final MilestoneRequests milestoneRequests = new MilestoneRequests();

    @Test
    public void getMilestoneCase(){
        String milestoneName = String.valueOf(milestoneRequests.getMilestoneRequest("1").get("name"));
        assertThat(milestoneName).isEqualTo("Release 2.0");
    }

    @Test
    public void updateMilestoneCase(){
        String milestoneNameFromResponse =
                String.valueOf(milestoneRequests.updateMilestoneRequest("1").get("name"));
        assertThat(milestoneNameFromResponse).isEqualTo("Release 1.0");
    }
}

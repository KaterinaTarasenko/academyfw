package org.academy.api;

import org.academy.api.requests.UserRequests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest extends BaseTest {
    private final UserRequests userRequests = new UserRequests();

    @Test
    public void getAllUsersCase() {
        String userRole = String.valueOf(userRequests.getAllUsersRequest().get("role"));
        assertThat(userRole).isEqualTo("Lead").as("User role need to be 'Lead'");
    }
}

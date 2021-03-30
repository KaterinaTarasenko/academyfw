package org.academy.ui.steps;

import lombok.extern.slf4j.Slf4j;
import org.academy.ui.pages.MainPage;
import org.academy.ui.pages.administration.ProjectsPage;

@Slf4j
public class AddProjectSteps extends Steps {
    public ProjectsPage createProject() {
        return createProject(getProjectName(), getProjectAnnouncement());
    }

    public ProjectsPage createProject(String name) {
        return createProject(name, getProjectAnnouncement());
    }

    public ProjectsPage createProject(String name, String announcement) {
        return new MainPage()
                .clickOnAddProjectBtn()
                .fillNameField(name)
                .fillAnnouncementField(announcement)
                .clickOnAcceptBtn();
    }
}

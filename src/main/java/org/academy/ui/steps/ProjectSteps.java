package org.academy.ui.steps;

import lombok.extern.slf4j.Slf4j;
import org.academy.ui.pages.MainPage;
import org.academy.ui.pages.administration.ProjectsPage;
import org.academy.ui.pages.project.EditProjectPage;

@Slf4j
public class ProjectSteps extends Steps {
    public ProjectsPage createProject() throws InterruptedException {
        return createProject(getProjectName(), getProjectAnnouncement());
    }

    public ProjectsPage createProject(String name) throws InterruptedException {
        return createProject(name, getProjectAnnouncement());
    }

    public ProjectsPage createProject(String name, String announcement) throws InterruptedException {
        return new MainPage()
                .clickOnAddProjectBtn()
                .fillNameField(name)
                .fillAnnouncementField(announcement)
                .clickOnAcceptBtn();
    }

    public EditProjectPage openEditProjectPage() {
        return openEditProjectPage(getProjectName());
    }

    public EditProjectPage openEditProjectPage(String projectName) {
        return new MainPage()
                .clickOnAdministrationLink()
                .clickOnProjectsBtn()
                .clickOnProjectPage(projectName);
    }
}

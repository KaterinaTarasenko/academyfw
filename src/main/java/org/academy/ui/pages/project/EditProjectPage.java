package org.academy.ui.pages.project;

import org.academy.ui.pages.AddProjectPage;
import org.openqa.selenium.By;

public class EditProjectPage extends AddProjectPage {


    public EditProjectPage() {
        super();
    }

    public EditProjectPage(boolean navigate, String navigateToUrl) {
        super(navigate, navigateToUrl);
    }

    public EditProjectPage clearProjectName() {
        findElement(nameField).clear();
        return this;
    }

    public EditProjectPage clearAnnouncementField() {
        findElement(announcementField).clear();
        return this;
    }


}

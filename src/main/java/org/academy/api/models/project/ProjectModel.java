package org.academy.api.models.project;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectModel {
    private String name;
    private String announcement;
    @JsonProperty("show_announcement")
    private boolean showAnnouncement;
    @JsonProperty("suite_mode")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int suiteMode;
    private boolean isCompleted;

    public ProjectModel() {
    }

    public ProjectModel(Builder builder) {
        name = builder.name;
        announcement = builder.announcement;
        showAnnouncement = builder.showAnnouncement;
        suiteMode = builder.suiteMode;
        isCompleted = builder.isCompleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean getShowAnnouncement() {
        return showAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }

    public int getSuiteMode() {
        return suiteMode;
    }

    public void setSuiteMode(int suiteMode) {
        this.suiteMode = suiteMode;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) { this.isCompleted = isCompleted;
    }

    public static class Builder {
        private String name;
        private String announcement;
        private boolean showAnnouncement;
        private int suiteMode;
        private boolean isCompleted;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder announcement(String announcement) {
            this.announcement = announcement;
            return this;
        }

        public Builder showAnnouncement(boolean showAnnouncement) {
            this.showAnnouncement = showAnnouncement;
            return this;
        }

        public Builder suiteMode(int suiteMode) {
            this.suiteMode = suiteMode;
            return this;
        }

        public Builder isCompleted(boolean isCompleted) {
            this.isCompleted = isCompleted;
            return this;
        }

        public ProjectModel build() {
            return new ProjectModel(this);
        }
    }
}

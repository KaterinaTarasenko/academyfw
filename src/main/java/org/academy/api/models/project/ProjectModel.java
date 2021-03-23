package org.academy.api.models.project;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectModel {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int id;
    private String name;
    private String announcement;
    @JsonProperty("show_announcement")
    private boolean showAnnouncement;
    @JsonProperty("suite_mode")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int suiteMode;
    @JsonProperty("is_completed")
    private boolean isCompleted;
    @JsonProperty("completed_on")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String completedOn;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String url;

    public ProjectModel() {
    }

    public ProjectModel(Builder builder) {
        id = builder.id;
        name = builder.name;
        announcement = builder.announcement;
        showAnnouncement = builder.showAnnouncement;
        suiteMode = builder.suiteMode;
        isCompleted = builder.isCompleted;
        completedOn = builder.completedOn;
        url = builder.url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getCompletedOn() {
        return completedOn;
    }

    public String getUrl() {
        return url;
    }

    public static class Builder {
        private int id;
        private String name;
        private String announcement;
        private boolean showAnnouncement;
        private int suiteMode;
        private boolean isCompleted;
        private String completedOn;
        private String url;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
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

        public Builder completedOn(String completedOn) {
            this.completedOn = completedOn;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public ProjectModel build() {
            return new ProjectModel(this);
        }
    }
}

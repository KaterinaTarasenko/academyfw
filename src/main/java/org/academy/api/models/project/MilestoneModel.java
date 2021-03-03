package org.academy.api.models.project;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MilestoneModel {
    private String name;
    private String description;
    @JsonProperty("is_completed")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isCompleted;
    @JsonProperty("is_started")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isStarted;

    public MilestoneModel() {
    }

    public MilestoneModel(Builder builder){
        name = builder.name;
        description = builder.description;
        isCompleted = builder.isCompleted;
        isStarted = builder.isStarted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public static class Builder {
        private String name;
        private String description;
        private boolean isCompleted;
        private boolean isStarted;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder isCompleted(boolean isCompleted){
            this.isCompleted = isCompleted;
            return this;
        }

        public Builder isStarted(boolean isStarted){
            this.isStarted = isStarted;
            return this;
        }

        public MilestoneModel build() {
            return new MilestoneModel(this);
        }
    }
}

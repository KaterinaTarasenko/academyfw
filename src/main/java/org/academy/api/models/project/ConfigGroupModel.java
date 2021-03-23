package org.academy.api.models.project;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigGroupModel {
    private int id;
    private String name;
    @JsonProperty("project_id")
    private int projectId;
    //TODO private List<ConfigModel> configs;

    private ConfigGroupModel() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProjectId() {
        return projectId;
    }

    public static Builder newBuilder() {
        return new ConfigGroupModel().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setId(int id) {
            ConfigGroupModel.this.id = id;
            return this;
        }

        public Builder setName(String name){
            ConfigGroupModel.this.name = name;
            return this;
        }

        public Builder setProjectId(int projectId){
            ConfigGroupModel.this.projectId = projectId;
            return this;
        }

        public ConfigGroupModel build() {
            return ConfigGroupModel.this;
        }
    }
}

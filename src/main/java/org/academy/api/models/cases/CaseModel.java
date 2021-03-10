package org.academy.api.models.cases;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;

public class CaseModel {
  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("updated_id")
  private Integer updatedId;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("created_by")
  private Integer createdBy;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("created_on")
  private Timestamp createdOn;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("custom_expected")
  private String customExpected;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("custom_preconds")
  private String customPreconds;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("custom_steps")
  private String customSteps;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("custom_steps_seperated")
  private List<Object> customStepsSeparated;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  private Long estimate;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("estimate_forecast")
  private Long estimateForecast;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  private Integer id;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("milestone_id")
  private Integer milestoneId;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("priority_id")
  private Integer priorityId;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  private List<String> refs;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("section_id")
  private Integer sectionId;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("suite_id")
  private Integer suiteId;

  private String title;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("type_id")
  private Integer typeId;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("updated_by")
  private Integer updatedBy;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("updated_on")
  private Timestamp updatedOn;

  @JsonInclude(JsonInclude.Include.NON_DEFAULT)
  @JsonProperty("template_id")
  private Integer templateId;

  public CaseModel() {}

  public CaseModel(Builder builder) {
    createdBy = builder.createdBy;
    createdOn = builder.createdOn;
    estimate = builder.estimate;
    estimateForecast = builder.estimateForecast;
    id = builder.id;
    priorityId = builder.priorityId;
    milestoneId = builder.milestoneId;
    refs = builder.refs;
    sectionId = builder.sectionId;
    suiteId = builder.suiteId;
    templateId = builder.templateId;
    title = builder.title;
    typeId = builder.typeId;
    updatedId = builder.updatedId;
    updatedOn = builder.updatedOn;
  }

  public Integer getUpdatedId() {
    return updatedId;
  }

  public void setUpdatedId(Integer updatedId) {
    this.updatedId = updatedId;
  }

  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public Timestamp getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Timestamp createdOn) {
    this.createdOn = createdOn;
  }

  public String getCustomExpected() {
    return customExpected;
  }

  public void setCustomExpected(String customExpected) {
    this.customExpected = customExpected;
  }

  public String getCustomPreconds() {
    return customPreconds;
  }

  public void setCustomPreconds(String customPreconds) {
    this.customPreconds = customPreconds;
  }

  public String getCustomSteps() {
    return customSteps;
  }

  public void setCustomSteps(String customSteps) {
    this.customSteps = customSteps;
  }

  public List<Object> getCustomStepsSeparated() {
    return customStepsSeparated;
  }

  public void setCustomStepsSeparated(List<Object> customStepsSeparated) {
    this.customStepsSeparated = customStepsSeparated;
  }

  public Long getEstimate() {
    return estimate;
  }

  public void setEstimate(Long estimate) {
    this.estimate = estimate;
  }

  public Long getEstimateForecast() {
    return estimateForecast;
  }

  public void setEstimateForecast(Long estimateForecast) {
    this.estimateForecast = estimateForecast;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMilestoneId() {
    return milestoneId;
  }

  public void setMilestoneId(Integer milestoneId) {
    this.milestoneId = milestoneId;
  }

  public Integer getPriorityId() {
    return priorityId;
  }

  public void setPriorityId(Integer priorityId) {
    this.priorityId = priorityId;
  }

  public List<String> getRefs() {
    return refs;
  }

  public void setRefs(List<String> refs) {
    this.refs = refs;
  }

  public Integer getSectionId() {
    return sectionId;
  }

  public void setSectionId(Integer sectionId) {
    this.sectionId = sectionId;
  }

  public Integer getSuiteId() {
    return suiteId;
  }

  public void setSuiteId(Integer suiteId) {
    this.suiteId = suiteId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  public Integer getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Integer updatedBy) {
    this.updatedBy = updatedBy;
  }

  public Timestamp getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(Timestamp updatedOn) {
    this.updatedOn = updatedOn;
  }

  public Integer getTemplateId() {
    return templateId;
  }

  public void setTemplateId(Integer templateId) {
    this.templateId = templateId;
  }

  public static class Builder {
    private Integer createdBy;
    private Timestamp createdOn;
    private Long estimate;
    private Long estimateForecast;
    private Integer id;
    private Integer priorityId;
    private Integer milestoneId;
    private List<String> refs;
    private Integer sectionId;
    private Integer suiteId;
    private Integer templateId;
    private String title;
    private Integer typeId;
    private Integer updatedId;
    private Timestamp updatedOn;

    public Builder() {}

    public Builder id(int id) {
      this.id = id;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder suiteId(int suiteId) {
      this.suiteId = suiteId;
      return this;
    }

    public Builder createdBy(int createdBy) {
      this.createdBy = createdBy;
      return this;
    }

    public CaseModel build() {
      return new CaseModel(this);
    }
  }
}

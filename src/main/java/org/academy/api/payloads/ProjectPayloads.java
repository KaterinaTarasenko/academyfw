package org.academy.api.payloads;

import lombok.extern.slf4j.Slf4j;
import org.academy.api.models.project.ProjectModel;
import org.json.JSONObject;

@Slf4j
public class ProjectPayloads extends Payload {

    public String createProjectPayload(String name, String announcement, boolean showAnnouncement, int... suiteMode) {

        ProjectModel projectModel = suiteMode.length > 0
                ? new ProjectModel.Builder()
                .name(name)
                .announcement(announcement)
                .showAnnouncement(showAnnouncement)
                .suiteMode(suiteMode[0])
                .build()

                : new ProjectModel.Builder()
                .name(name)
                .announcement(announcement)
                .showAnnouncement(showAnnouncement)
                .build();

        String payload = jsonFromObject(projectModel);
        log.info("payload created = \r\n" + payload);
        return payload;
    }

    public String updateProjectPayload(String name, String announcement, boolean showAnnouncement, boolean isCompleted) {

        ProjectModel projectModel = new ProjectModel.Builder()
                .name(name)
                .announcement(announcement)
                .showAnnouncement(showAnnouncement)
                .isCompleted(isCompleted)
                .build();

        String payload = jsonFromObject(projectModel);
        log.info("payload updated = \r\n" + payload);
        return payload;
    }

    public String updateProjectPayload(String projectName, String announcement, int suiteMode) {
        ProjectModel projectModel = new ProjectModel.Builder()
                .name(projectName)
                .announcement(announcement)
                .suiteMode(suiteMode)
                .build();

        String payload = jsonFromObject(projectModel);
        log.info("payload updated = \r\n" + payload);
        return payload;
    }
}

package org.academy.api.payloads;

import lombok.extern.slf4j.Slf4j;
import org.academy.api.models.project.MilestoneModel;

@Slf4j
public class MilestonePayloads extends Payload {

    public String addMilestoneToProjectPayload(String name, String... description){

        MilestoneModel milestoneModel = description.length > 0
                ? new MilestoneModel.Builder()
                .name(name)
                .description(description[0])
                .build()

                : new MilestoneModel.Builder()
                .name(name)
                .build();

        String payload = jsonFromObject(milestoneModel);
        log.info("payload created = \r\n" + payload);
        return payload;
    }

    public String updateMilestoneStartedOn(String name, String... startedOn) {
        MilestoneModel milestoneModel = startedOn.length > 0
                ? new MilestoneModel.Builder()
                .name(name)
                .description(startedOn[0])
                .build()

                : new MilestoneModel.Builder()
                .name(name)
                .build();

        String payload = jsonFromObject(milestoneModel);
        log.info("payload created = \r\n" + payload);
        return payload;
    }

    public String updateMilestoneWithCompleteField(String name, String description, boolean... isCompleted){
        MilestoneModel milestoneModel = isCompleted.length > 0
                ? new MilestoneModel.Builder()
                .name(name)
                .description(description)
                .isCompleted(isCompleted[0])
                .build()

                : new MilestoneModel.Builder()
                .name(name)
                .description(description)
                .build();

        String payload = jsonFromObject(milestoneModel);
        log.info("payload updated = \r\n" + payload);
        return payload;
    }

    public String updateMilestoneWithStartedField(String name, String description, boolean... isStarted){
        MilestoneModel milestoneModel = isStarted.length > 0
                ? new MilestoneModel.Builder()
                .name(name)
                .description(description)
                .isStarted(isStarted[0])
                .build()

                : new MilestoneModel.Builder()
                .name(name)
                .description(description)
                .build();

        String payload = jsonFromObject(milestoneModel);
        log.info("payload updated = \r\n" + payload);
        return payload;
    }
}

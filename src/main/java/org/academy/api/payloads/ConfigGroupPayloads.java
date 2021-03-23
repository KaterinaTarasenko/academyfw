package org.academy.api.payloads;

import lombok.extern.slf4j.Slf4j;
import org.academy.api.models.project.ConfigGroupModel;

@Slf4j
public class ConfigGroupPayloads extends Payload {
    public String addConfigGroupPayload(String name) {
        ConfigGroupModel configGroupModel = ConfigGroupModel.newBuilder().setName(name).build();

        String payload = jsonFromObject(configGroupModel);
        log.info("payload created = \r\n" + payload);
        return payload;
    }
}

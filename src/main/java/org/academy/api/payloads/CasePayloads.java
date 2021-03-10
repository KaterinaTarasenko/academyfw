package org.academy.api.payloads;

import lombok.extern.slf4j.Slf4j;
import org.academy.api.models.cases.CaseModel;

@Slf4j
public class CasePayloads extends Payload {

    public String createCasePayload(String title) {

        CaseModel model = new CaseModel.Builder()
                .title(title).build();

        String payload = jsonFromObject(model);
        log.info("payload created = \r\n" + payload);
        return payload;
    }
}

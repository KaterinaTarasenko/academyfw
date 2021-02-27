package org.academy.api.payloads;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.academy.utils.helpers.exceptions.JsonFromObjectException;

@Slf4j
public abstract class Payload {

    <T> String jsonFromObject(T object) {
        try {
            return (new ObjectMapper()).writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new JsonFromObjectException(e.getMessage());
        }
    }
}

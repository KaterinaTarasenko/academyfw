package org.academy.api.payloads;

public class ProjectPayloads {
    public String projectPayload(String projectName) {
        return String.format("{\n" +
                "\t\"name\": \"%s\",\n" +
                "\t\"announcement\": \"This is the description for the project\",\n" +
                "\t\"show_announcement\": true\n" +
                "}", projectName);
    }
}

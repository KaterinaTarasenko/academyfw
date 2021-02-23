package org.academy.utils.helpers;

import java.sql.Timestamp;

public class ApiHelpers {
    public String getCurrentTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }
}

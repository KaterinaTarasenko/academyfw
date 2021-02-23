package org.academy;

public class MainConfig {

    protected static String read(String value) {
        return PropertyReader.get().readValue(value);
    }

    public static String getBrowser() {
        return read("ts.browser");
    }

    public static String getGurockUrl() {
        return read("ts.gurock_url");
    }

    public static String getAccountUrl() {
        return read("ts.account_url");
    }

    public static String getEmail() {
        return read("ts.email");
    }

    public static String getPassword() {
        return read("ts.password");
    }

    public static String navToPage(String pageName) {
        return read("ts.gurock_url") + read(pageName);
    }

    public static String getProjectName() {
        return read("ts.projectName");
    }

    public static String getProjectAnnouncement() {
        return read("ts.projectAnnouncement");
    }

    public static String getFullName() {
        return read("ts.fullName");
    }

    public static String getMilestoneName() {
        return read("ts.milestoneName");
    }

    public static String getMilestoneReference() {
        return read("ts.milestoneReference");
    }

    public static String getMilestoneDescription() {
        return read("ts.milestoneDescription");
    }
}

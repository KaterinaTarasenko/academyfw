package org.academy.api.requests;

import org.academy.MainConfig;

public class Resources extends MainConfig {
    public static String prefixResource() {
        return read("rs.prefix");
    }

    public static String allUsersResource() {
        return read("rs.all_users");
    }

    public static String allSuitesResource() {
        return read("rs.all_suites");
    }

    public static String addProjectResource() {
        return read("rs.add_project");
    }

    public static String getProjectResource() {
        return read("rs.get_project");
    }

    public static String updateProjectResource() {
        return read("rs.update_project");
    }
}

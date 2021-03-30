package org.academy.api;

import org.academy.MainConfig;
import org.academy.utils.helpers.ApiHelpers;
import org.academy.utils.helpers.DataRandomizer;

public abstract class BaseTest extends MainConfig {
    protected ApiHelpers apiHelpers = new ApiHelpers();
    protected DataRandomizer dr = new DataRandomizer();
}

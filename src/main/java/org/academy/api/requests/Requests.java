package org.academy.api.requests;

import org.academy.utils.api.methods.GetMethods;
import org.academy.utils.api.methods.PostMethods;

public abstract class Requests extends Resources {
    protected GetMethods getMethods = new GetMethods();
    protected PostMethods postMethods = new PostMethods();
}

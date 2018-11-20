package com.mockito;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RestApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    public RestApplication() {
        singletons.add(new MessageRestService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}

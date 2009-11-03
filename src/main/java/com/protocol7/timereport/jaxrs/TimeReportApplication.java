package com.protocol7.timereport.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;



public class TimeReportApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> rrcs = new HashSet<Class<?>>();
        
        rrcs.add(TimeReportService.class);
        rrcs.add(TimeReportHtmlWriter.class);
        rrcs.add(TimeReportICalWriter.class);

        return rrcs;
    }
}
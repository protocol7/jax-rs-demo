package com.protocol7.timereport.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.protocol7.timereport.dao.TimeReportDao;
import com.protocol7.timereport.model.TimeReport;

@Path("report/{username}")
public class TimeReportService {

    private TimeReportDao reportDao = new TimeReportDao();

    @GET
    public TimeReport getReport(@PathParam("username") String username) {
        return reportDao.forUser(username);
    }
    
    @PUT
    public void saveReport(TimeReport report) {
        reportDao.update(report);
    }
}
package com.protocol7.timereport.dao;

import java.util.ArrayList;
import java.util.List;

import com.protocol7.timereport.model.TimeRange;
import com.protocol7.timereport.model.TimeReport;


public class TimeReportDao implements GenericDao<TimeReport, String> {

    public void delete(TimeReport range) {
    }

    public String create(TimeReport newInstance) {
        // TODO implement
        return null;
    }

    public TimeReport forUser(String username) {
        return read(username);
    }
    
    public TimeReport read(String username) {
        TimeRangeDao rangeDao = new TimeRangeDao();
        
        // For now, return a dummy reply
        List<TimeRange> ranges = new ArrayList<TimeRange>();
        ranges.add(rangeDao.read("1"));
        ranges.add(rangeDao.read("2"));
        ranges.add(rangeDao.read("3"));

        TimeReport report = new TimeReport(username, ranges);
        
        return report;
    }

    public void update(TimeReport transientObject) {
        // TODO implement
        
    }

    
}

package com.protocol7.timereport.dao;

import java.util.Date;

import com.protocol7.timereport.model.TimeRange;

public class TimeRangeDao implements GenericDao<TimeRange, String> {

    public void delete(TimeRange range) {
    }

    public String create(TimeRange newInstance) {
        // TODO implement
        return null;
    }

    @SuppressWarnings("deprecation")
	public TimeRange read(String id) {
    	int taskId = Integer.parseInt(id);
        return new TimeRange("Task " + id, new Date(109, 1, 2, taskId, 4, 5), new Date(109, 1, 2,  + taskId + 2, 4, 5));
    }

    public void update(TimeRange transientObject) {
        // TODO implement        
    }

    
}

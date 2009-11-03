package com.protocol7.timereport.model;

import java.util.Date;

public class TimeRange {

    private Date startTime;
    private Date endTime;
    private String description;
    
    public TimeRange(String description, Date startTime, Date endTime) {
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getStartTime() {
        return startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public String getDescription() {
        return description;
    }
}

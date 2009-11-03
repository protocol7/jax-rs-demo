package com.protocol7.timereport.model;

import java.util.List;

public class TimeReport {

	private String user;
    private List<TimeRange> ranges;

    public TimeReport(String user, List<TimeRange> ranges) {
		this.user = user;
		this.ranges = ranges;
	}

	public String getUser() {
		return user;
	}

	public List<TimeRange> getRanges() {
        return ranges;
    }
}

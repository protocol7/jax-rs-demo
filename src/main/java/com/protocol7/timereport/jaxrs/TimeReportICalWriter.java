package com.protocol7.timereport.jaxrs;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.protocol7.timereport.model.TimeRange;
import com.protocol7.timereport.model.TimeReport;

@Provider
@Produces("text/calendar")
public class TimeReportICalWriter implements MessageBodyWriter<TimeReport> {

	private DateFormat DF = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");

	private String render(TimeReport t) {
		StringBuffer sb = new StringBuffer();

		sb.append("BEGIN:VCALENDAR\n");
		sb.append("PRODID:-//TimeReport Demo//TimeReport Demo//EN\n");
		sb.append("VERSION:2.0\n");
		sb.append("CALSCALE:GREGORIAN\n");
		sb.append("METHOD:PUBLISH\n");

		for (TimeRange range : t.getRanges()) {
			sb.append("BEGIN:VEVENT\n");
			sb.append("DTSTART:" + DF.format(range.getStartTime()) + "\n");
			sb.append("DTEND:" + DF.format(range.getEndTime()) + "\n");
			sb.append("SUMMARY:" + range.getDescription() + "\n");
			sb.append("END:VEVENT\n");
		}

		sb.append("END:VCALENDAR");

		return sb.toString();
	}

	public void writeTo(TimeReport t, Class<?> type, Type genericType,
			Annotation[] annotations, javax.ws.rs.core.MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) {

		PrintWriter wr = new PrintWriter(entityStream);
		wr.write(render(t));
		wr.flush();
	}

	public long getSize(TimeReport t, Class<?> type, Type genericType,
			Annotation[] annotations, javax.ws.rs.core.MediaType mediaType) {

		return render(t).length();
	}

	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, javax.ws.rs.core.MediaType mediaType) {
		return type.equals(TimeReport.class);
	}

}
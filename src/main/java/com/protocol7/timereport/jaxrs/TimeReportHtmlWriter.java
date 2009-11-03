package com.protocol7.timereport.jaxrs;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.protocol7.timereport.model.TimeRange;
import com.protocol7.timereport.model.TimeReport;

@Provider
@Produces("text/html")
public class TimeReportHtmlWriter implements MessageBodyWriter<TimeReport> {

	private DateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
    private String render(TimeReport t) {

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head><title>Report for " + t.getUser() + "</title>");
        sb.append("<body>");
        sb.append("<h1>Report for " + t.getUser() + "</h1>");

        sb.append("<table>");
        for(TimeRange range : t.getRanges())  {
            sb.append("<tr>");
            sb.append("<td>" + DF.format(range.getStartTime()) + " - </td>");
            sb.append("<td>" + DF.format(range.getEndTime()) + " : </td>");
            sb.append("<td>" + range.getDescription() + "</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    public long getSize(TimeReport t, Class<?> type, Type genericType,
            Annotation[] annotations, javax.ws.rs.core.MediaType mediaType) {
        return render(t).length();
    }

    public boolean isWriteable(Class<?> type, Type genericType,
            Annotation[] annotations, javax.ws.rs.core.MediaType mediaType) {
        return type.equals(TimeReport.class);
    }

    public void writeTo(TimeReport t, Class<?> type, Type genericType,
            Annotation[] annotations, javax.ws.rs.core.MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException,
            WebApplicationException {
        
        OutputStreamWriter wr = new OutputStreamWriter(entityStream);
        wr.write(render(t));
        wr.flush();

    }

}
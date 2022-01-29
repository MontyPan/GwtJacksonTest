package us.dontcareabout.GwtJacksonTest.client.util.gf;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

public interface ResponseHandler {
	void onReceive(Request request, Response response);
}

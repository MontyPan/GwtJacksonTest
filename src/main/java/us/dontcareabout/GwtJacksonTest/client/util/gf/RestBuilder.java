package us.dontcareabout.GwtJacksonTest.client.util.gf;

import com.google.gwt.http.client.RequestBuilder;

public class RestBuilder extends RequestBuilder2 {
	public RestBuilder(String path) {
		super(path);
	}

	@Override
	protected void custom(RequestBuilder builder) {
		if (getMethod() == RequestBuilder.POST || getMethod() == RequestBuilder.PUT) {
			builder.setHeader("Content-Type", "application/json");
		}
	}
}

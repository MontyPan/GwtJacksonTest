package us.dontcareabout.GwtJacksonTest.client.util.gf;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

import us.dontcareabout.gwt.client.data.Callback;

public class RequestBuilder2 {
	public final String path;

	private Method method;
	private Callback<?> errorCB;

	public RequestBuilder2(String path) {
		this.path = path;
	}

	public void request(ResponseHandler handler) {
		request(null, handler);
	}

	public void request(String requestData, ResponseHandler handler) {
		RequestBuilder builder = new RequestBuilder(method, path);
		custom(builder);

		try {
			builder.sendRequest(requestData, new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					handler.onReceive(request, response);
				}

				@Override
				public void onError(Request request, Throwable exception) {
					handleError(exception);
				}
			});
		} catch (Exception e) {
			handleError(e);
		}
	}

	protected void custom(RequestBuilder builder) {}

	private void handleError(Throwable e) {
		if (errorCB == null) { return; }

		errorCB.onError(e);
	}

	////////////////////////////////

	public RequestBuilder2 get() {
		method = RequestBuilder.GET;
		return this;
	}
	public RequestBuilder2 post() {
		method = RequestBuilder.POST;
		return this;
	}
	public RequestBuilder2 put() {
		method = RequestBuilder.PUT;
		return this;
	}
	public RequestBuilder2 delete() {
		method = RequestBuilder.DELETE;
		return this;
	}
	public RequestBuilder2 head() {
		method = RequestBuilder.HEAD;
		return this;
	}
	public Method getMethod() {
		return method;
	}
	public Callback<?> getErrorCallback() {
		return errorCB;
	}
	public RequestBuilder2 setErrorCallback(Callback<?> callback) {
		this.errorCB = callback;
		return this;
	}
}
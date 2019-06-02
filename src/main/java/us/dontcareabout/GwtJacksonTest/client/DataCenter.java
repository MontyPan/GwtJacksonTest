package us.dontcareabout.GwtJacksonTest.client;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import us.dontcareabout.GwtJacksonTest.shared.Normal;
import us.dontcareabout.gwt.client.Console;

public class DataCenter {
	private final static RpcServiceAsync rpc = GWT.create(RpcService.class);

	interface NormalMapper extends ObjectMapper<Normal> {}
	static NormalMapper mapper = GWT.create(NormalMapper.class);

	public static void normal() {
		rpc.normal(new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				Normal foo = mapper.read(result);
				Console.inspect(foo);
			}

			@Override
			public void onFailure(Throwable caught) {}
		});
	}
}

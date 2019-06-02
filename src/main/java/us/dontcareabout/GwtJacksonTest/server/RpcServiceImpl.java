package us.dontcareabout.GwtJacksonTest.server;

import com.google.gson.Gson;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import us.dontcareabout.GwtJacksonTest.client.RpcService;
import us.dontcareabout.GwtJacksonTest.shared.Normal;

public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {
	private static final long serialVersionUID = 1L;

	private static final Gson gson = new Gson();

	@Override
	public String normal() {
		Normal result = new Normal();
		result.setDoubleD(3.1415926);
		result.setLongV(Long.MAX_VALUE);
		result.setString("String");
		result.intPublic = Integer.MIN_VALUE;
		return gson.toJson(result);
	}

}

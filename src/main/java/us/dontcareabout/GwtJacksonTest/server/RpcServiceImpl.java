package us.dontcareabout.GwtJacksonTest.server;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import us.dontcareabout.GwtJacksonTest.client.RpcService;
import us.dontcareabout.GwtJacksonTest.shared.Normal;

public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {
	private static final long serialVersionUID = 1L;

	@Override
	public String normal(String datePattern) {
		Gson gson = new GsonBuilder().setDateFormat(datePattern).create();
		Normal result = new Normal();
		result.setDoubleD(3.1415926);
		result.setLongV(Long.MAX_VALUE);
		result.setString("String");
		result.intPublic = Integer.MIN_VALUE;
		result.setDate(new Date());
		return gson.toJson(result);
	}

}

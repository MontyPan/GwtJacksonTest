package us.dontcareabout.GwtJacksonTest.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("RPC")
public interface RpcService extends RemoteService{
	String normal(String datePattern);
	String fail();
}

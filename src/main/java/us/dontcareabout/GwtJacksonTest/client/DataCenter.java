package us.dontcareabout.GwtJacksonTest.client;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.GWT;

import us.dontcareabout.GwtJacksonTest.shared.Fail;
import us.dontcareabout.GwtJacksonTest.shared.Normal;

public class DataCenter {
	interface NormalMapper extends ObjectMapper<Normal> {}
	static NormalMapper mapper = GWT.create(NormalMapper.class);

	interface FailMapper extends ObjectMapper<Fail>{}
	static FailMapper failMapper = GWT.create(FailMapper.class);

}

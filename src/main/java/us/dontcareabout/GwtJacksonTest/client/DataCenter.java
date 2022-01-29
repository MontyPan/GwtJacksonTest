package us.dontcareabout.GwtJacksonTest.client;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.GWT;

import us.dontcareabout.GwtJacksonTest.client.util.gf.RestBuilder;
import us.dontcareabout.GwtJacksonTest.shared.Fail;
import us.dontcareabout.GwtJacksonTest.shared.Normal;
import us.dontcareabout.gwt.client.Console;

public class DataCenter {
	interface NormalMapper extends ObjectMapper<Normal> {}
	static NormalMapper mapper = GWT.create(NormalMapper.class);

	interface FailMapper extends ObjectMapper<Fail>{}
	static FailMapper failMapper = GWT.create(FailMapper.class);

	public static void receiveNormal() {
		new RestBuilder("api/receiveNormal").post().request(
			mapper.write(Normal.sample),
			(req, resp) -> Console.log("receiveNormal() : " + resp.getText())
		);
	}

	public static void sendNormal() {
		new RestBuilder("api/sendNormal").get().request(
			(req, resp) -> Console.log(
				"sendNormal() : " + (Normal.sample.equals(mapper.read(resp.getText())))
			)
		);
	}
}

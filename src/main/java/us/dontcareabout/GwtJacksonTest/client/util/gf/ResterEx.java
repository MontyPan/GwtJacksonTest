package us.dontcareabout.GwtJacksonTest.client.util.gf;

import java.util.List;

import com.github.nmorel.gwtjackson.client.ObjectMapper;

import us.dontcareabout.GwtJacksonTest.shared.gf.HasId;
import us.dontcareabout.gwt.client.data.Callback;

public class ResterEx<T extends HasId<ID>, ID> extends Rester<T, ID> {

	public ResterEx(String name, ObjectMapper<T> mapper) {
		super(name, mapper);
	}

	public void getAll(Callback<List<T>> callback) {
		new RestBuilder(name + "/all").get().setErrorCallback(callback).request(
			(req, resp) -> {
				callback.onSuccess(JacksonUtil.read(resp.getText(), mapper));
			}
		);
	}

	public void batchCreate(List<T> data, Callback<Integer> callback) {
		new RestBuilder(name + "/batchCreate").post().setErrorCallback(callback).request(
			JacksonUtil.write(data, mapper),
			(req, resp) -> {
				callback.onSuccess(resp.getStatusCode());
			}
		);
	}
}

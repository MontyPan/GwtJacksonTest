package us.dontcareabout.GwtJacksonTest.client.util.gf;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;

import us.dontcareabout.GwtJacksonTest.shared.gf.HasId;
import us.dontcareabout.gwt.client.data.Callback;

public class Rester<T extends HasId<ID>, ID> {
	public final String name;
	public final ObjectMapper<T> mapper;

	public Rester(String name, ObjectMapper<T> mapper) {
		this.name = name;
		this.mapper = mapper;
	}

	public void getEntry(T data, Callback<T> callback) {
		getEntry(data.getId(), callback);
	}

	public void getEntry(ID id, Callback<T> callback) {
		new RestBuilder(name + "/" + id.toString()).get().setErrorCallback(callback).request(
			(req, resp) -> {
				HalEntry entry = JsonUtils.safeEval(resp.getText());
				callback.onSuccess(mapper.read(entry.toPojoJson()));
			}
		);
	}

	public void delete(T data, Callback<Integer> callback) {
		new RestBuilder(name + "/" + data.getId()).delete().request(
			(req, resp) -> callback.onSuccess(resp.getStatusCode())
		);
	}

	/**
	 * 依照 id 是否為 null 自動呼叫對應的 HTTP method。
	 */
	public void save(T data, Callback<Integer> callback) {
		if (data.getId() == null) {
			post(data, callback);
		} else {
			put(data, callback);
		}
	}

	public void post(T data, Callback<Integer> callback) {
		act(RequestBuilder.POST, name, data, callback);
	}

	public void put(T data, Callback<Integer> callback) {
		act(RequestBuilder.PUT, name + "/" + data.getId(), data, callback);
	}

	private void act(Method method, String uri, T data, Callback<Integer> callback) {
		new RestBuilder(uri).setMethod(method).setErrorCallback(callback).request(
			mapper.write(data),
			(req, resp) -> callback.onSuccess(resp.getStatusCode())
		);
	}
}
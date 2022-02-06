package us.dontcareabout.GwtJacksonTest.client.util.gf;

import java.util.ArrayList;
import java.util.List;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;

public class JacksonUtil {
	/**
	 * 這是為了不多製造一個 ObjectMapper<List<T>> 而搞出來的東西。
	 */
	public static <T> List<T> read(String json, ObjectMapper<T> mapper) {
		JsArray<JavaScriptObject> jsArray = JsonUtils.safeEval(json);
		ArrayList<T> result = new ArrayList<>();

		for (int i = 0; i < jsArray.length(); i++) {
			//把每個 element 再變回 json，這樣 mapper 就能處理了，愚蠢但有效的招式 XD
			result.add(mapper.read(JsonUtils.stringify(jsArray.get(i))));
		}

		return result;
	}

	/**
	 * 這是為了不多製造一個 ObjectMapper<List<T>> 而搞出來的東西。
	 */
	public static <T> String write(List<T> data, ObjectMapper<T> mapper) {
		StringBuilder result = new StringBuilder();

		for (T t : data) {
			result.append(mapper.write(t) + ",");
		}

		return "[" + result.substring(0, result.length() - 1) + "]";
	}
}

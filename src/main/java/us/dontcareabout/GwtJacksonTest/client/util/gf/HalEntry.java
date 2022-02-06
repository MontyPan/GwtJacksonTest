package us.dontcareabout.GwtJacksonTest.client.util.gf;

import com.google.gwt.core.client.JavaScriptObject;

public final class HalEntry extends JavaScriptObject {
	protected HalEntry() {}

	/**
	 * 還原成 POJO 原本的 JSON 樣子。
	 * 主要是拔掉<code>._link</code>，並加回 id 值
	 */
	public native String toPojoJson() /*-{
		var href = this._links.self.href;
		//重新 clone 一個，避免其他地方會需要原本的 JSON
		var result = JSON.parse(JSON.stringify(this));
		result["id"] = href.substring(href.lastIndexOf("/") + 1);
		delete result._links;
		return JSON.stringify(result);
	}-*/;
}

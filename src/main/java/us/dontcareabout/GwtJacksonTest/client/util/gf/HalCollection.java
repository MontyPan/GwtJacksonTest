package us.dontcareabout.GwtJacksonTest.client.util.gf;

import com.google.gwt.core.client.JavaScriptObject;

public final class HalCollection extends JavaScriptObject {
	protected HalCollection() {}

	public String toPojoJson() {
		StringBuffer result = new StringBuffer("[");

		for (HalEntry entry : getEmbedded()) {
			result.append(entry.toPojoJson() + ",");
		}

		return result.substring(0, result.length() - 1) + "]";
	}

	public native HalEntry[] getEmbedded() /*-{
		var keys = Object.keys(this._embedded);
		return this._embedded[keys[0]];
	}-*/;

	public native HalPage getPage() /*-{
		return this.page;
	}-*/;
}

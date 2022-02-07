package us.dontcareabout.GwtJacksonTest.client.util.gf;

import com.google.gwt.core.client.JavaScriptObject;

public final class HalPage extends JavaScriptObject {
	protected HalPage() {}

	public native int getSize() /*-{
		return this.size;
	}-*/;

	public native int getTotalElements() /*-{
		return this.totalElements;
	}-*/;

	public native int getTotalPages() /*-{
		return this.totalPages;
	}-*/;

	public native int getNumber() /*-{
		return this.number;
	}-*/;
}

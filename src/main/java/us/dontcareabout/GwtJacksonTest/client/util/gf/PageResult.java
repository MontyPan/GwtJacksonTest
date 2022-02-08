package us.dontcareabout.GwtJacksonTest.client.util.gf;

import java.util.List;

public class PageResult<T> {
	public final HalPage page;
	public final List<T> result;

	public PageResult(HalPage page, List<T> result) {
		this.page = page;
		this.result = result;
	}
}

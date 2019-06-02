package us.dontcareabout.GwtJacksonTest.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;

import us.dontcareabout.gwt.client.GFEP;
import us.dontcareabout.gwt.client.iCanUse.Feature;
import us.dontcareabout.gxt.client.draw.LayerContainer;

public class GwtJacksonTestEP extends GFEP {
	static final RpcServiceAsync rpc = GWT.create(RpcService.class);

	public GwtJacksonTestEP() {
		needFeature(Feature.WebSocket);
	}

	@Override
	protected String version() { return "0.0.1"; }

	@Override
	protected String defaultLocale() { return "zh_TW"; }

	@Override
	protected void featureFail() {
		Window.alert("這個瀏覽器我不尬意，不給用..... \\囧/");
	}

	@Override
	protected void start() {
		LayerContainer main = new MainView();
		Viewport viewport = new Viewport();
		viewport.add(main);
		RootPanel.get().add(viewport);
	}
}

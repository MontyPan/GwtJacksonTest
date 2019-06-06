package us.dontcareabout.GwtJacksonTest.client;

import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent;
import com.sencha.gxt.chart.client.draw.sprite.SpriteSelectionEvent.SpriteSelectionHandler;

import us.dontcareabout.gxt.client.draw.LayerContainer;
import us.dontcareabout.gxt.client.draw.component.TextButton;

public 	class MainView extends LayerContainer {
	TextButton normal = gen("標準 pojo");
	TextButton fail = gen("失敗-1");

	public MainView() {
		normal.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				DataCenter.normal();
			}
		});
		addLayer(normal);

		fail.addSpriteSelectionHandler(new SpriteSelectionHandler() {
			@Override
			public void onSpriteSelect(SpriteSelectionEvent event) {
				DataCenter.fail();
			}
		});
		addLayer(fail);
	}

	@Override
	protected void onResize(int width, int height) {
		normal.setLX(10);
		normal.setLY(10);
		normal.resize(200, 50);

		fail.setLX(10);
		fail.setLY(70);
		fail.resize(200, 50);

		super.onResize(width, height);
	}

	private static TextButton gen(String text) {
		TextButton result = new TextButton(text);
		result.setBgRadius(10);
		result.setBgColor(RGB.RED);
		result.setTextColor(RGB.WHITE);
		return result;
	}
}
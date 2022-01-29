package us.dontcareabout.GwtJacksonTest.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import us.dontcareabout.GwtJacksonTest.shared.Normal;

@RestController
@RequestMapping("api")
public class RestCtrller {

	@PostMapping("/receiveNormal")
	public boolean recieveNormal(@RequestBody Normal normal) {
		return normal.equals(Normal.sample);
	}

	@GetMapping("/sendNormal")
	public Normal sendNormal() {
		return Normal.sample;
	}
}

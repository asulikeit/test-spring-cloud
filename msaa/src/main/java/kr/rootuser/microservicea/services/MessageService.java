package kr.rootuser.microservicea.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope
public class MessageService {
	
	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private ApplicationConfiguration configration;

	@GetMapping("/message")
	public Map<String, String> welcome() {

		Map<String, String> map = new HashMap<String, String>();
		String message = configration.getMessage();
		log.info("message : " + message);
		map.put("message", message);
		return map;
	}

}

package kr.rootuser.microservicea.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

	private Log log = LogFactory.getLog(getClass());

	@GetMapping("/random")
	public List<Integer> random() {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			numbers.add(100 + i);
		}

		log.info("Returning " + numbers);
		return numbers;
	}
}

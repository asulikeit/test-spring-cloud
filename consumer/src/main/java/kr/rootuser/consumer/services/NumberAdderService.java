package kr.rootuser.consumer.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NumberAdderService {
	private Log log = LogFactory.getLog(getClass());

	@Value("${number.service.url")
	private String numberServiceUrl;

	@GetMapping("/add")
	public Long add() {
		long sum = 0;

		ResponseEntity<Integer[]> responseEntity = new RestTemplate().getForEntity(numberServiceUrl, Integer[].class);
		Integer[] numbers = responseEntity.getBody();

		for (int number : numbers) {
			sum += number;
		}

		log.info("Returning " + sum);
		return sum;
	}
}

package com.sinkashot.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SearchHelpController {
private final Logger logger = LoggerFactory.getLogger(SearchHelpController.class);
	
	@GetMapping(path = "/search/help/host")
	public String getSearchHelpHost() {
		logger.info("getSearchHelpHost()");

		return "{\r\n"
				+ "    \"result\": true,\r\n"
				+ "    \"data\": [\r\n"
				+ "        {\r\n"
				+ "            \"group\":\"개발\",\r\n"
				+ "            \"host\":\"01\",\r\n"
				+ "            \"ip\":\"1.1.1.1\",\r\n"
				+ "            \"usage\":\"테스트1\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"group\":\"개발\",\r\n"
				+ "            \"host\":\"02\",\r\n"
				+ "            \"ip\":\"2.2.2.2\",\r\n"
				+ "            \"usage\":\"테스트2\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"group\":\"운영\",\r\n"
				+ "            \"host\":\"03\",\r\n"
				+ "            \"ip\":\"3.3.3.3\",\r\n"
				+ "            \"usage\":\"운영1\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"group\":\"운영\",\r\n"
				+ "            \"host\":\"04\",\r\n"
				+ "            \"ip\":\"4.4.4.4\",\r\n"
				+ "            \"usage\":\"운영2\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
	}
}

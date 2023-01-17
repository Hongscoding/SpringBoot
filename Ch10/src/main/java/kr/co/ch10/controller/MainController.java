package kr.co.ch10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = {"/","/index"})
	public String index() {
		
		logger.trace("tracelog");
		logger.debug("debug log");
		logger.info("infolog");
		logger.warn("warn log");
		logger.error("errorlog");
		
		return "/index";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "/hello";
	}
	@GetMapping("/welcome")
	public String welcome() {
		return "/welcome";
	}
	@GetMapping("/greeting")
	public String greeting() {
		return "/greeting";
	}
	
	
}

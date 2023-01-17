package kr.co.ch10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 어노테이션
@Controller
public class SubController {


	// 로거 생성
	//Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping("/sub/hello")
	public String hello() {
		
		log.trace("hello trace log");
		log.debug("hello debug log");
		log.info("hello info log");
		log.warn("hello warn log");
		log.error("hello error log");

		return "/sub/hello";
	}
	@GetMapping("/sub/welcome")
	public String welcome() {
		
		log.trace("welcome trace log");
		log.debug("welcome debug log");
		log.info("welcome info log");
		log.warn("welcome warn log");
		log.error("welcome error log");
		
		return "/sub/welcome";
	}
	@GetMapping("/sub/greeting")
	public String greeting() {
		
		log.trace("greeting trace log");
		log.debug("greeting debug log");
		log.info("greeting info log");
		log.warn("greeting warn log");
		log.error("greeting error log");
		
		return "/sub/greeting";
	}
	
	
}

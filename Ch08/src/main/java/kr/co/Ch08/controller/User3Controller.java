package kr.co.Ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class User3Controller {
	
	@GetMapping("/user3/login")
	public String login() {
		return "/user3/login";
	}
	
	@GetMapping("/user3/loginSuccess")
	public String loginSuccess() {
		return "/user3/loginSuccess";
	}

}

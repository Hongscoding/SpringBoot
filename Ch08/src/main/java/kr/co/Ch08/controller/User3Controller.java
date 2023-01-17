package kr.co.Ch08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.Ch08.service.User3Service;
import kr.co.Ch08.vo.User3VO;

@Controller
public class User3Controller {

	@Autowired
	private User3Service service;	
	
	@GetMapping("/user3/login")
	public String login() {
		return "/user3/login";
	}
	
	@GetMapping("/user3/loginSuccess")
	public String loginSuccess() {
		return "/user3/loginSuccess";
	}
	
	@GetMapping("/user3/register")
	public void register() {}
	
	@PostMapping("/user3/register")
	public String register(User3VO vo) {
		
		service.insertUser3(vo);
		
		return "redirect:/user3/login";
	}
}
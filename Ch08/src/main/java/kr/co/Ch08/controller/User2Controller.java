package kr.co.Ch08.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.Ch08.service.User2Service;
import kr.co.Ch08.vo.User2VO;

@Controller
public class User2Controller {
	
	private User2Service service;
	
	@GetMapping("/user2/login")
	public String login() {
		return "/user2/login";
	}
	
	@PostMapping("/user2/login")
	public String login(String uid, String pass, HttpSession sess) {
		User2VO user = service.selectUser2(uid, pass);
		
		if(user != null) {
			// 회원이 맞을 경우
			sess.setAttribute("sessUser", user);
			return "redirect:/user2/loginSuccess";
			
		}else {
			// 회원이 아닐 경우
			return "redirect:/user2/login?success=100";
		}
		
	}
	
	@GetMapping("/user2/loginSuccess")
	public String loginSuccess() {
		return "/user2/loginSuccess";
	}
	
	@GetMapping("/user2/logout")
	public String logout(HttpSession sess) {
		
		sess.invalidate();
		
		return "redirect:/user2/login?success=101";
	}

	
	
	
	
	
	
	
	
	
}

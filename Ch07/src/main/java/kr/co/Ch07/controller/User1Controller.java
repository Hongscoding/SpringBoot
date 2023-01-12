package kr.co.Ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.Ch07.vo.User1VO;
import lombok.extern.slf4j.Slf4j;
import kr.co.Ch07.service.User1Service;

@Slf4j
@Controller
public class User1Controller {
	
	@Autowired
	private User1Service service;
	
	@GetMapping("/user1/list")
	public String list(Model model) {
		List<User1VO> users = service.selectUser1s();	
		
		model.addAttribute("users", users);
		return "/user1/list";
	}
	
	@GetMapping("/user1/modify")
	public String modify(Model model, String uid) {
		User1VO user = service.selectUser1(uid);
		
		model.addAttribute("user", user);
		return "/user1/modify";
	}
	@PostMapping("/user1/modify")
	public String modify(User1VO vo) {
		log.error("vo - ", vo);
		service.updateUser1(vo);
		
		return "redirect:/user1/list";
	}
	
	@GetMapping("/user1/register")
	public String register() {
		return "/user1/register";
	}
	@PostMapping("/user1/register")
	public String register(User1VO vo) {
		service.insertUser1(vo);
		
		return "redirect:/user1/list";
	}
	
	@GetMapping("/user1/delete")
	public String delete(String uid) {
		service.deleteUser1(uid);
		
		return "redirect:/user1/list";
	}
	
	

}

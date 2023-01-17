package kr.co.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	@GetMapping("/book/list")
	public String book() {
		return "/book/list";
	}
	
}

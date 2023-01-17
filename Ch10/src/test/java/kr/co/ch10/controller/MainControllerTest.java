package kr.co.ch10.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class MainControllerTest {
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MockMvc mvc;
	
	@Test 
	public void index() throws Exception {
		// index 요청 테스트
		mvc.perform(get("/index")).andExpect(status().isOk()).andDo(print());
	}
	
	// 테스트 코드 실행 전에 실행되는 코드
	@BeforeAll
	public static void before() {
		System.out.println("before 실행");
	}
	
	@Test
	public void hello() throws Exception {
		// hello 요청 테스트
		mvc.perform(get("/hello")).andExpect(status().isOk()).andDo(print());
	}

}

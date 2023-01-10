package kr.co.Ch07;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("kr.co.Ch07.dao") // 패키지 하위의 매퍼를 찾는 것
@SpringBootApplication
public class Ch07Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch07Application.class, args);
	}

}

package kr.co.swiftER;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("kr.co.swiftER.dao") // 패키지 하위의 매퍼를 찾는 것
@SpringBootApplication
public class SwiftERApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiftERApplication.class, args);
	}

}

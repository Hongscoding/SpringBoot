package kr.co.Ch06.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok 기본 설정
@Getter
@Setter
@AllArgsConstructor // 모든 매개변수 생성자
@NoArgsConstructor // 위에랑 세트
@ToString // 필드의 값을 출력해주는 메서드
public class UserVO {
	
	private String uid;
	private String name;
	private String hp;
	private int age;
	

}

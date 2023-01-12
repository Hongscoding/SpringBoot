package kr.co.Ch07.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user4")
public class User4VO {
	
	@Id
	private String seq;
	private String name;
	private String birth;
	private int gender;
	private int age;
	private String addr;
	
}

package kr.co.Ch08.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.Ch08.vo.User3VO;

public interface User3Repo extends JpaRepository<User3VO, String>{
	
	public User3VO findUser3VOByUidAndPass(String uid, String pass);
	
}

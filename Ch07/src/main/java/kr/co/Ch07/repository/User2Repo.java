package kr.co.Ch07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.Ch07.vo.User2VO;

public interface User2Repo extends JpaRepository<User2VO, String>{
	
	

}

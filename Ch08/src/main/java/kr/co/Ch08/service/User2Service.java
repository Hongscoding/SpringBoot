package kr.co.Ch08.service;

import org.springframework.stereotype.Service;

import kr.co.Ch08.repository.User2Repo;
import kr.co.Ch08.vo.User2VO;

@Service
public class User2Service {
	
	private User2Repo repo;
	
	public void insertUser2() {
		
	}
	public User2VO selectUser2(String uid, String pass) {
		return repo.findUser2VOByUidAndPass(uid, pass);
		
	}
	public void selectUser2s() {
		
	}
	public void updateUser2() {
		
	}
	public void deleteUser2() {
		
	}

}

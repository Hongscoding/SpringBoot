package kr.co.Ch08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.Ch08.repository.User3Repo;
import kr.co.Ch08.vo.User3VO;

@Service
public class User3Service implements  UserDetailsService{
	
	@Autowired
	private User3Repo repo;
	
	public void insertUser2() {
		
	}
	public User3VO selectUser3(String uid, String pass) {
		return repo.findUser3VOByUidAndPass(uid, pass);
		
	}
	public void selectUser2s() {
		
	}
	public void updateUser2() {
		
	}
	public void deleteUser2() {
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User3VO user = repo.findById(username).get();
		
		if(user == null) {
			System.out.println("user x");
			throw new UsernameNotFoundException(username);

		}
		
		UserDetails userDts = User.builder()
								  .username(user.getUid())
								  .password(user.getPass())
								  .roles("ADMIN")
								  .build();
		
		return userDts;
	}
	
	
	
	
	
	
	

}

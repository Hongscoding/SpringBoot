package kr.co.Ch08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.Ch08.repository.User3Repo;
import kr.co.Ch08.security.MyUserDetails;
import kr.co.Ch08.vo.User3VO;

@Service
public class User3Service implements  UserDetailsService{
	
	@Autowired
	private User3Repo repo;
	
	public void insertUser3(User3VO vo) {
		
		// Spring Security 암호화 처리
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		vo.setPass(passEncoder.encode(vo.getPass()));
		
		repo.save(vo);
		
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
		
		/*
		UserDetails userDts = User
								.builder()
								.username(user.getUid())
								.password(user.getPass())
								.roles("ADMIN")
								.build();
		*/
		
	//	return userDts;
		
		MyUserDetails myUser = new MyUserDetails();
		myUser.setUid(user.getUid());
		myUser.setPass(user.getPass());
		myUser.setName(user.getName());
		myUser.setHp(user.getHp());
		myUser.setAge(user.getAge());
		myUser.setRdate(user.getRdate().toString());
		
		return myUser;
		
		
	}
	
	
	
	
	
	
	

}

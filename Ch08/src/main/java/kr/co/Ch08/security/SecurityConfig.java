package kr.co.Ch08.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.Ch08.service.User3Service;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 접근권한 설정
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER");
		http.authorizeRequests().antMatchers("/member/**").hasAnyRole("ADMIN","MANAGER", "member");
		
		// 사이트 위조 방지 설정
		http.csrf().disable();
		
		// 로그인 설정
		http.formLogin()
		.loginPage("/user3/login")
		.defaultSuccessUrl("/user3/loginSuccess")
		.usernameParameter("uid")
		.passwordParameter("pass");		
		
		// 로그아웃 설정
		http.logout()
		.invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/user3/logout"))
		.logoutSuccessUrl("/user3/login");
		
		
		
		
	}
	
	@Autowired
	private User3Service userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		// Security 사용자에 대한 권한 설정
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("manager").password("{noop}1234").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER");
		
		// 로그인 인증 처리 서비스, 암호화 방식 설정
		auth.userDetailsService(userService).passwordEncoder(new MessageDigestPasswordEncoder("SHA-256"));
	
	}
	
}
package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.mapper.UserMapper;
import com.kh.security.vo.User;

@Service
public class UserService{

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder bcpe;
		
	public void register(User user) {
		user.setPwd(bcpe.encode(user.getPwd()));
		if(user.getId().equals("admin")) {
			user.setRole("ROLE_ADMIN");
		} else {
			user.setRole("ROLE_USER");
		}
		mapper.register(user);
	}
	
	public User login(User user) {
		User u = mapper.login(user.getId());
		
		if(u != null && bcpe.matches(user.getPwd(), u.getPwd())) {
			System.out.println("로그인 성공:)");
			return u;
		}
		return null;
	}




	
	
	

}

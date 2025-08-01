package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.security.mapper.UserMapper;
import com.kh.security.vo.User;

@Service
public class UserService implements UserDetailsService{

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = mapper.login(username);
		System.out.println(user);
		return user;
		
	}



	
	
	

}

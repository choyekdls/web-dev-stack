package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.service.UserService;
import com.kh.security.vo.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// index 페이지 열기
	@GetMapping("/index")
	public String index() {
		return"/index";
	}
	
	@GetMapping("/register")
	public void register() {
	}
	
	
	@GetMapping("/login")
	public void login() {
	}
	
	@GetMapping("/myPage")
	public void myPage() {
		
	}
	
	@GetMapping("/admin")
	public void admin() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		System.out.println(user);
		
		
	}
	
	@PostMapping("/register")
	public String register(User user) {
		System.out.println(user);
		userService.register(user);
		return "redirect:/login";
	}

	@PostMapping("/login")
	public String login(String user, HttpServletRequest request) {
		
		return "redirect:/myPage";
	}
	
}

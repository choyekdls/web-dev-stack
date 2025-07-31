package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.service.UserService;
import com.kh.security.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	// index 페이지 열기
	@GetMapping("/index")
	public String index() {
		return"/index";
	}
	
	@GetMapping("/register")
	public void register() {
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@PostMapping("/register")
	public String register(User user) {
		service.register(user);
		return "index";
	}

	@PostMapping("/login")
	public String login(String user, HttpServletRequest request) {
		User u = service.login(user);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", u);
		return "redirect:/index";
	}
	
}

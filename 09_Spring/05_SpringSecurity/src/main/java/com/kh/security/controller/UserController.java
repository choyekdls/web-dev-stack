package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.security.config.TokenProvider;
import com.kh.security.service.UserService;
import com.kh.security.vo.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenProvider tokenProvider;

    UserController(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }
	
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

	@ResponseBody
	@PostMapping("/login")
	public String login(User user) {
		User u = userService.login(user);
		if(u != null) {
			// 로그인 성공 -> 서버는 토큰 생성만, 가지고 있는 클라이언트
			String token = tokenProvider.create(u);
			return token;
		}
		return "redirect:/";
	}
	
}

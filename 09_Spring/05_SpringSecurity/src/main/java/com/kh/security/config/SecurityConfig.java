package com.kh.security.config;

import com.kh.security.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable()) // 웹 보안 토큰 설정 (비활성화) 
				.httpBasic(basic -> basic.disable()) // 우리가 맞춰서 쓸거다-.- 라는 의미/HTTP Basic 인증 방식 비활성화 -> JWT 토큰 방식 사용
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 세션 설정 -> STATELESS 무상태(서버에서 기억하지 않게) 방식으로 설정하겠다 라는 의미
				.authorizeHttpRequests(authorize -> authorize // 어디까지   
						.requestMatchers("/myPage").authenticated()
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll()) // 어떤 요청이든 전부 수락할게 anyRequest().permitAll()
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

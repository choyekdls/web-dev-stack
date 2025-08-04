package com.kh.security.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.kh.security.vo.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// 토큰 생성 코드
// 비즈니스로직에 붙이는 어노테이션 : 서비스 입니다
@Service
public class TokenProvider {
	
	private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	//  유저가 로그인 했을 때 보낼 토큰 생성
	public String create(User user) {
		return Jwts.builder()
				.signWith(secretKey, SignatureAlgorithm.HS512)
				.setClaims(Map.of(
						"id", user.getId(),
						"name", user.getName(),
						"role", user.getRole()
						))
				// 언제 발급 됐는지 : 토큰 발급 시점
				.setIssuedAt(new Date())
				// 언제 만료 되는지 : 토큰 만료 시점
				.setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
				.compact();
	}
	
	public User validate(String token) {
		Claims claims = Jwts
				.parserBuilder()
				.setSigningKey(secretKey)
				.build()
				.parseClaimsJws(token)
				.getBody();
		
		return User.builder()
				.id((String) claims.get("id"))
				.name((String) claims.get("name"))
				.role((String) claims.get("role"))
				.build();
		
	}

}

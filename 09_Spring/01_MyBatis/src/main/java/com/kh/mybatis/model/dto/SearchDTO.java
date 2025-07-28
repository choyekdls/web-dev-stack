package com.kh.mybatis.model.dto;

import lombok.Getter;
import lombok.Setter;

// DTO(Data Transfer Object) : 데이터 전송 객체
// 전송해야할 데이터가 많을 때 DTO를 사용합니다

@Getter @Setter
public class SearchDTO {
	
	private String select;
	private String keyword;

}

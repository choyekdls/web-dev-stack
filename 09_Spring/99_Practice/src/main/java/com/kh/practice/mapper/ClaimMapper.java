package com.kh.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.practice.dto.ClaimDTO;
import com.kh.practice.vo.Claim;


@Mapper
public interface ClaimMapper {
	
	void newClaim(Claim claim);
	List<Claim> searchClaim(ClaimDTO dto);
	List<Claim> allClaim();
	Claim selectClaim(int claimNo);
	int updateClaim(Claim claim);
	int deleteClaim(int claimNo);
	
	

}
package com.kh.practice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kh.practice.dto.ClaimDTO;
import com.kh.practice.mapper.ClaimMapper;
import com.kh.practice.vo.Claim;


@Service
public class ClaimService{

	@Autowired
	private ClaimMapper mapper;
	
	// 신규 클레임 등록
	@Transactional
	public void newClaim(Claim claim) {
        mapper.newClaim(claim);
    }
	
	// 클레임 조회
	public List<Claim> searchClaim(ClaimDTO dto) {
		return mapper.searchClaim(dto);
	}

	// 클레임 전체 조회
	public List<Claim> allClaim() {
		return mapper.allClaim();
	}
	
    // 클레임 선택 수정버튼 이동
	public Claim selectClaim(int claimNo) {
		Claim claim = mapper.selectClaim(claimNo);

		if (claim.getDefectType() != null && !claim.getDefectType().equals("")) {
			claim.setDefectTypeList(Arrays.asList(claim.getDefectType().split(",")));
		}
		return claim;
	}
	
	// 클레임 수정
	public int updateClaim(Claim claim) {
		return mapper.updateClaim(claim);
	}
	
	// 회수 상태 -> 완료 -> 수정 버튼 클릭 시 재고에 자동 반영
	@Transactional
	public void returnInven(Claim claim) {
	// 클레임 업데이트
	mapper.updateClaim(claim);

	
}

	// 클레임 삭제
	public int deleteClaim(int claimNo) {
		return mapper.deleteClaim(claimNo);
	}

	
	
}
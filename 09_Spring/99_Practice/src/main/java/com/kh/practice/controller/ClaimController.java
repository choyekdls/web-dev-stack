package com.kh.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.practice.dto.ClaimDTO;
import com.kh.practice.service.ClaimService;
import com.kh.practice.vo.Claim;

@Controller
public class ClaimController {

	@Autowired
	private ClaimService service;
	
	// 메인 화면
		@GetMapping("/main")
		public String main() {
			return "page/main";
		}
		
		// 메뉴
		@GetMapping("/sidebar")
		public String sidebar() {
			return "/page/sidebar";
		}
		
		// 클레임 등록
		@GetMapping("/newClaim")
		public String newClaim() {
			return"/page/claimPage/newClaim";
		}
		
	
	
	// 신규 클레임 등록
	
	@PostMapping("/newClaim")
	public String newClaim(Claim claim) {
		service.newClaim(claim);
		
		return "redirect:/allClaim";
	}
	
	// 클레임 조회
	
	@PostMapping("/allClaim")
	public String keyword(ClaimDTO dto, Model model) {
	    String keyword = dto.getKeyword();
	    List<Claim> list;

	    if (keyword == null || keyword.trim().isEmpty()) {
	        list = service.allClaim();
	    } else {
	        list = service.searchClaim(dto);
	    }

	    for (Claim claim : list) {
	        if (claim.getDefectTypeList() != null) {
	            claim.setDefectType(String.join(", ", claim.getDefectTypeList()));
	        }
	    }

	    model.addAttribute("claimList", list);
	    return "/page/claimPage/allClaim";
	}
	
	// 클레임 전체 조회
	@GetMapping("/allClaim")
	public String allClaim(Model model) {
		
	// 클레임 전체 목록 받아오기
	List<Claim> list = service.allClaim();
		
	for (Claim claim : list) {
	   if (claim.getDefectTypeList() != null) {
	   claim.setDefectType(String.join(", ", claim.getDefectTypeList()));
	}
}

	//모델에 추가
	model.addAttribute("claimList", list);
		
		return "/page/claimPage/allClaim";
		}
	
	// 선택한 클레임 값 넘기기
	@GetMapping("/updateClaim")
	public String selectClaim(int claimNo, Model model) {
		Claim claim = service.selectClaim(claimNo);

	    // defectTypeList → defectType 문자열 변환
	    if (claim.getDefectTypeList() != null) {
	        claim.setDefectType(String.join(", ", claim.getDefectTypeList()));
	    }

	    model.addAttribute("claim", claim);
	    return "/page/claimPage/updateClaim";
	}
	
	
	// 클레임 수정
	@PostMapping("/updateClaim")
	public String updateClaim(Claim claim) {
	    if (claim.getDefectTypeList() != null) {
	        claim.setDefectType(String.join(", ", claim.getDefectTypeList()));
	    }
	    service.returnInven(claim);
	    service.updateClaim(claim);
	    
	    return "redirect:/allClaim";
	}
	
	// 클레임 삭제
	@ResponseBody
	@PostMapping("/deleteClaim")
	public String deleteClaim(int claimNo) {
		service.deleteClaim(claimNo);
		return "/page/claimPage/allClaim";
		
	}
}
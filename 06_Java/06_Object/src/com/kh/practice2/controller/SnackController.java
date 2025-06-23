package com.kh.practice2.controller;

import com.kh.practice2.model.Snack;

public class SnackController {

	private Snack s = new Snack();
	
	public String saveData(Snack snackData) {   
		s.setKind(snackData.getKind()); 
		s.setName(snackData.getName());
		s.setFlavor(snackData.getFlavor());
		s.setNumOf(snackData.getNumOf());
		s.setPrice(snackData.getPrice());
		return "데이터를 저장완료하였습니다.";
	}
	

    public Snack confirmData() {
		return s;
	}
}

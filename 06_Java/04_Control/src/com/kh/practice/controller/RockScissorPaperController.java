package com.kh.practice.controller;

import java.util.Arrays;

import com.kh.practice.model.RockScissorPaper;

public class RockScissorPaperController {

	 RockScissorPaper rspModel = new RockScissorPaper();
	 private int computerch;
	 
	 // 컴퓨터 랜덤값 추출 - 가위바위보
	 public String randomComputer() {
		 // 컴퓨터 - 0: 가위, 1: 바위, 2: 보
		 int computerch = (int)(Math.random()*3);
		 // 컴퓨터는 인덱스로 값을 찾음!
	     return rspModel.getRsp()[computerch];
	 }
	 
	 // 컴퓨터 랜덤값
	 public int computerch() {
		 return computerch;
	 }
	 
	 // 사용자가 입력한 값으로 인덱스 찾기
	 public int userIndex(String choose) {
		 return Arrays.asList(rspModel.getRsp()).indexOf(choose);
	 }
	 
	 // 비긴 경우
	 public void rspDraw() {
		 rspModel.setDraw(rspModel.getDraw() + 1);
	 }
	 
	 // 이긴 경우
	 public void rspWin() {
		 rspModel.setWin(rspModel.getWin() + 1);
	 }
	 
	 // 진 경우
	 public void rspLose() {
		 rspModel.setLose(rspModel.getLose() + 1);
	 }
	 
	 // 결과 정보 확인
	 public String rspResult() {
		return "비긴 횟수 : " + rspModel.getDraw()
                + ", 진 횟수 : " + rspModel.getLose()
                + ", 이긴 횟수 : " + rspModel.getWin();
	 }
	 
	 // 가위바위보 게임 진행
	 public int rspGame(String choose) {
		 int result = 3;
		 int chooseResult= userIndex(choose);
		
		 if (chooseResult == computerch) {
	    		result = 1;
				rspDraw();}
	    	
	    	else if (chooseResult == 0 && computerch == 2 ||
	    			chooseResult == 1 && computerch == 0 ||
	    					chooseResult == 2 && computerch == 1 ) {
	    		result = 2;
	    		rspWin();
	    		}
	    	
	    	else {
	    		result = 3;
	    	    rspLose();
	    }	
		 return result;
	 }
}

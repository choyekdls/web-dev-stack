package com.kh.practice.view;

import java.util.Random;
import java.util.Scanner;

import com.kh.practice.controller.RockScissorPaperController;

public class RockScissorPaperView {

	RockScissorPaperController controller = new RockScissorPaperController();
	Scanner sc = new Scanner(System.in);
	
	public void gameStart() {
		
    	int computerch;
       
    	Random random = new Random();

    	System.out.print("당신의 이름을 입력해주세요 > ");
    	String name = sc.nextLine();
    	
    	System.out.println("게임을 시작합니다!");
    	
    	while(true) {
    	System.out.print("가위바위보!\n > ");
    	String choose = sc.nextLine();
    	
    	System.out.println("컴퓨터 : " + controller.randomComputer());
    	System.out.println(name + " : " + choose);
    	
    	// 사용자는 값으로 인덱스를 찾으면 어떨까?
    	// 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값을 숫자로
    	
    	int result = controller.rspGame(choose);
    	
    	if (!choose.equals("가위") && !choose.equals("바위") && !choose.equals("보")) {
    		System.out.println("가위, 바위, 보 중 하나를 입력하세요. 게임을 재시작합니다.");
    	} 
    	
    	if (result == 1) {
    		System.out.println("비겼습니다");
			controller.rspDraw();}
    	
    	else if (result == 2) {
    		System.out.println("이겼습니다!");
    		controller.rspWin();
    		System.out.println(controller.rspResult());
    		break;}
    	
    	else if (result == 3){
    	System.out.println("졌습니다...ㅠ.ㅠ");
	}
	}
	}
}

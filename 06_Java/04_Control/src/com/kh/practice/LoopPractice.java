package com.kh.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.kh.practice.controller.RockScissorPaperController;
import com.kh.practice.model.RockScissorPaper;
import com.kh.practice.view.RockScissorPaperView;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
		l.method6();
//		l.method7();
//		l.method8();
//		l.method9();
		
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
   
		System.out.println("1~100까지의 숫자를 입력해주세요 > ");
		int num = sc.nextInt();

		for (int i = num; i >= 1; i--) {
			System.out.println(i);
		}
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
		int num = 0;
		int sum = 0;
     
		// true 부분을 sum < 100으로 적어도 됨
		while (true) {
			if (num % 2 == 0) {sum -= num;}
			else {sum += num;}	
			if (sum >= 100) {break;}
			num++;
		}
		System.out.println(num);
    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.println("문자열을 입력해주세요. > ");
    	String word = sc.nextLine();
    	
    	System.out.println("검색하실 문자를 입력해주세요. > ");
    	char alphabet = sc.next().charAt(0);
    	
    	int i = 0;
    	int count = 0;
    	
    	// char [] wordArr = word.toCharArray();// 문자열을 배열로 바꾸고나서는..? 배열에서 alphabet과 같은 문자 찾기...
    	// for(i = 0; i < wordArr.length(); i++){
    	// if (wordArr == alphabet){count++;}
    	// System.out.println(count); 
    	
    	for(i = 0; i < word.length(); i++) {
    		if (word.charAt(i) == alphabet) {
    			count++;
    		}
    	} System.out.println(count);

    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10) // 이전에 출력한 숫자들을 중복되지 않게 하는 방법은...?
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	
    	while(true) {
    	int random = (int) (Math.random() * 11);
    	System.out.println(random);
    	if(random == 0) break;
    	}
    	
    	/* 내가 짠 것
    	Random random = new Random();
    	int num;
    	
    	while(true) {
    		num = random.nextInt(11);
    		System.out.println(num);
    		
    		if(num == 0) {break;}
         }*/ 
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() { 
		int dice1 = 0;
		int dice2 = 0;
		int dice3 = 0;
		int dice4 = 0;
		int dice5 = 0;
		int dice6 = 0;

		for (int i = 0; i < 10; i++) {
			int random = (int) (Math.random() * 6 + 1);

			switch (random) {
			case 1:
				dice1++;
				break;
			case 2:
				dice1++;
				break;
			case 3:
				dice1++;
				break;
			case 4:
				dice1++;
				break;
			case 5:
				dice1++;
				break;
			case 6:
				dice1++;
				break;
			}
		} 
		System.out.println("1 : " + dice1);
		System.out.println("2 : " + dice2);
		System.out.println("3 : " + dice3);
		System.out.println("4 : " + dice4);
		System.out.println("5 : " + dice5);
		System.out.println("6 : " + dice6);
	}
    
    public void method7() { 
    	int[] dice = new int[6];
    	
    	for (int i = 0; i < 10; i++) {
			int random = (int) (Math.random() * 6);
			dice[random]++;
			}
    	for(int i = 0; i < dice.length; i++) {
    		System.out.println((i+1) + " : " + dice[i]);
    	}
    }
    	
    	
    	
    	/*
    	Random random = new Random();
    	int [] dice = {1, 2, 3, 4, 5, 6};
    	int [] count = new int[6];
    	// System.out.println(Arrays.toString(dice));
    	int i = 0;
    	
    	for(i = 0; i < 10; i++) {
    		int roll = random.nextInt(6);
    	// 그 다음은.....모르겠어요....*/
    			
    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    
    public void method6() {
    	
    	RockScissorPaperView view = new RockScissorPaperView();
    	view.gameStart();
}
    
    public void method8() {
    	int win = 0;
    	int lose = 0;
    	int draw = 0;
    	
    	System.out.print("당신의 이름을 입력해주세요 > ");
    	String name = sc.nextLine();
    	
    	while(true) {
    		System.out.print("가위바위보 : ");
    		String input = sc.nextLine();
    		
    		// 컴퓨터 - 0: 가위, 1: 바위, 2: 보
    		int computer = (int)(Math.random()*3);
    		String computerName = "";
    		
    		switch(computer) {
    		case 0:
    			computerName = "가위";
    			break;
    		case 1:
    			computerName = "바위";
    			break;
    		case 2:
    			computerName = "보";
    			break;
    		}
    		System.out.println("컴퓨터 : " + computerName);
    		System.out.println(name + " : " + input);
    		
    		if(input.equals(computerName)) {
    			System.out.println("비겼습니다.");
    			draw++;
    		} else if(input.equals("가위") && computerName.equals("보") ||
    				  input.equals("바위") && computerName.equals("가위") ||
    				  input.equals("보") && computerName.equals("바위") ) {
    			System.out.println("이겼습니다!!") ;
    			win++;
    			System.out.println("비긴 횟수 : " + draw + ", 진 횟수 : " + lose + ", 이긴 횟수 : " + win);
    			break;
    		} else { System.out.println("졌습니다..ㅠ.ㅠ");
    		  lose++;
    			
    		}
    	}
    }

    
    public void method9() {
    	int win = 0;
    	int lose = 0;
    	int draw = 0;
    	
    	System.out.print("당신의 이름을 입력해주세요 > ");
    	String name = sc.nextLine();
    	
    	while(true) {
    		System.out.print("가위바위보 : ");
    		String input = sc.nextLine();
    		int inputResult = 3;
    		
    		switch(input) {
    		case "가위" : 
    			inputResult = 0;
    			break;
    		case "바위" : 
    			inputResult = 1;
    			break;
    		case "보" : 
    			inputResult = 2;
    			break;
    		}
    		
    		// 컴퓨터 - 0: 가위, 1: 바위, 2: 보
    		int computer = (int)(Math.random()*3);
    		String computerName = "";
    		
    		switch(computer) {
    		case 0:
    			computerName = "가위";
    			break;
    		case 1:
    			computerName = "바위";
    			break;
    		case 2:
    			computerName = "보";
    			break;
    		}
    		System.out.println("컴퓨터 : " + computerName);
    		System.out.println(name + " : " + input);
    		
    		if(inputResult == computer) {
    			System.out.println("비겼습니다.");
    			draw++;
    		} else if(inputResult == 0 && computer == 2 ||
    				inputResult == 1 && computer == 0 ||
    				inputResult == 2 && computer == 1 ) {
    			System.out.println("이겼습니다!!") ;
    			win++;
    			System.out.println("비긴 횟수 : " + draw + ", 진 횟수 : " + lose + ", 이긴 횟수 : " + win);
    			break;
    		} else { System.out.println("졌습니다..ㅠ.ㅠ");
    		  lose++;
    			
    		}
    	}
    }
}

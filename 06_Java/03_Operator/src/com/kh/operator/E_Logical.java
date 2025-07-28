package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
	
	/*
	 * 논리 연산자
	 * - 두 개의 논리값을 연산해주는 연산자
	 * - 논리 연산한 결과마저 논리값
	 * 
	 * 논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘 다 true일 경우만 결과값이 true
	 * 논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중에 하나라도 true일 경우 결과값이 true
	 * 
	 * */
	
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	
		E_Logical e = new E_Logical();
//		e.method1();
//		e.method2();	
		e.practice();
	}
    public void method1() {
    	// 사용자가 입력한 정수값이 1부터 100사이의 값인지 확인
    	
    	System.out.print("정수값 입력 > ");
    	int number = sc.nextInt();
    	boolean result = number >= 1 && number <=100;
    	System.out.println(result);
    }
    
    public void method2() {
    	int number = 10;
    	boolean result = false;
    	
    	// Short Cut Evaluation
    	// true && true = true
    	// true && false = false
    	// false && true = false
    	// false && false = false
    	// && 연산자를 기준으로 앞에서 이미 false이면 굳이 뒤쪽 연산 수행하지 않는다
    	result = (number < 5) && (++number > 0); 
    	System.out.println(result); // false
    	System.out.println(number); // && 앞의 조건이 false라서 뒤의 조건 ++number가 계산이 되지 않았음 그래서 number의 값이 10인 것이다
    	
    	// ||
    	// true || true = true
    	// true || false = true
    	// false || true = true
    	// false || false = false
    	// || 연산자를 기준으로 앞에서 이미 true이면 굳이 뒤쪽 연산 수행하지 않는다
    	result = (number < 20) || (++number > 0);
    	
    	System.out.println(result); //true
    	System.out.println(number); //10
    }
    
    /*
     * 문제!
     * 
     * 사용자가 입력한 문자 값이 알파벳인지 확인하기
     * A ~ Z : 65 ~ 90, a ~ z : 97 ~ 122
     * */
    public void practice () {
    	//System.out.print("문자값 입력 > ");
    	//char ch = sc.nextLine().charAt(0);
    	//boolean result = (65 <= ch && 90 >= ch) || (97 <= ch && 122 >= ch);
    	//System.out.println("알파벳인가? " + result);
    	
//    	int num = sc.nextInt(); // 숫자로 입력하고 입력한 숫자에 해당하는 알파벳까지 보고싶다면..?
//    	boolean result = ('A' <= ch && 'Z' >= ch) || ('a' <= ch && 'z' >= ch);
    	
    	System.out.print("숫자 입력 > ");
    	int num = sc.nextInt();
    	
    	boolean result = 'A' <= num && num <= 'Z' || 'a' <= num && num <= 'z';
    	System.out.println(result ? "알파벳 " + (char)num + "입니다" : "알파벳이 아니네요..");
    }
}

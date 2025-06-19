package com.kh.step3.model;

public class Calculator {

	/*
	 * 메서드(method)
	 * - 어떤 기능을 수행하는 명령문의 집합
	 * - 입력값(Parameter)을 받아서, 결과값(Return)을 돌려줄 수 있음
	 * - 단, 입력 받는 값이 없을 수도 있고, 결과를 돌려주지 않을 수도 있음 (무조건 받을 수 있는 것도, 무조건 돌려주는 것도 아님)
	 * - 하나의 메서드는 한 가지 기능만 수행하도록 작성하는 것이 좋음(SRP원칙 : 1기능, 1메서드)
	 * - return 반환값이 없는 경우 리턴타입이 void
	 * 
	 * 리턴타입 메서드명(파라미터, ..) {
	 *    실행문;
	 *    return 반환값;
	 *    }
	 * */
	public int a;
	public int b;
	
	// 더하기
	public int add() { // return 타입이 없을 때(반환하는게 없을 때) 쓰는게 void, void위치에는 return 타입에 맞춰 적기
		return a + b;
	}
	
	// 빼기
	public int minus() {
	    return a - b;
	}
	
	// 곱하기
	public int multiply(int a, int b) {
		return a * b;
	}	
	
	// 나누기 : divide
	// 몫은 12, 나머지는 3
	public static String divide (int a, int b) {
		return "몫은 " + (a / b) + ", 나머지는 " + (a % b);
	}
	
	
}

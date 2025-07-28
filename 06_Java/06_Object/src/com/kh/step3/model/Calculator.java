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
	
	/*
	 * 인스턴스(객체) 메서드 : 인스턴스 변수나 인스턴스 메서드와 관련된 작업을 하는 메서드
	 * 클래스(static) 메서드 : static 변수나 static 메서드와 관련된 작업을 하는 메서드
	 * */
	
	// 나누기 : divide
	// 몫은 12, 나머지는 3
	public static String divide (int a, int b) {
		return "몫은 " + quotient(a, b) + ", 나머지는 " + remainder(a, b);
	}
	
	// 두 수의 몫을 구하는 기능
	public static int quotient(int a, int b) {
		return a / b;
	}
	// 두 수의 나머지를 구하는 기능
	public static int remainder(int a, int b) {
		return a % b;
	}
	
	/*
	 * 팩토리얼!
	 * 1! = 1
	 * 2! = 2 x 1 = 2
	 * 3! = 3 x 2 x 1 = 6
	 * n! = n x (n-1) x (n-2) x ... x1
	 * */
	
	// 바뀌는 부분은 파라미터에 빼줍니다........ㅠ.ㅠ
	public int factorial(int n) {
		int result = 1;
		
		int i = 0;
	    for(i = n; i >= 1; i--) {
	    	result *= i;
	    }
		return result;
	}
	
	/*
	 * 재귀법, 재귀 함수(Recursion Function)
	 * - 메서드 내에서 자기자신을 반복적으로 호출
	 * - 반목문으로 바꿀 수 있으며 때때로 반복문보다 성능이 나쁠 때도 있음
	 * - 이해하면 간결한 코드 작성 가능
	 * */
	public int factorial2(int n) {
        int result = 1;
		
		if(n!=1) result = n * factorial2(n - 1);
		return result;
	}
	}

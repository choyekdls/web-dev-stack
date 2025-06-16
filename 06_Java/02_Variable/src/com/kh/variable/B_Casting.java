package com.kh.variable;

public class B_Casting {
	
	/*
	 * 형 변환(Casting)
	 * - 값의 타입을 다른 타입으로 변환하는 것
	 * - boolean을 제외한 7개의 기본형은 서로 형변환이 가능
	 * */

	public static void main(String[] args) {
		B_Casting casting = new B_Casting();
//		casting.autoCasting();
		casting.casting();

	}
	
	/*
	 * 자동 형 변환 (묵시적 형 변환)
	 * - 자동으로 형 변환이 이루어지기 때문에 따로 형 변환 하지 않아도 된다.
	 * */
	public void autoCasting() {
		// 정수
		byte b = 10; // 1byte
		short s = b; // 2byte 자동으로 알아서 형 변환이 이뤄졌다 이겁니다.. 
		int i = s; // 4byte 작은 것 -> 큰 것은 문제 없이 자동적으로 알아서 형 변환이 이루어지는게 가능함
		long l = i; // 8byte
		
		// 실수
		float f = 1; // 4byte
		double d = f; //8byte
		
		d = i; // int(정수) -> double(실수)
		f = l; // long(8, 정수) -> float(4, 실수)
		// -> 표현 가능한 수의 범위가 더 크기 때문에 담아지는 것임,,,정수보다는 실수가 더 크니까..
		
		int result = b + s; // byte, short 타입의 데이터는 연산시 무조건 int 타입
		System.out.println(result);
		
		double result2 = 10 + 3.3;
		System.out.println(result2);
	}
	
	/*
	 * 강제 형 변환 (명시적 형 변환)
	 * 
	 * (자료형)값;
	 * 
	 * - 범위가 큰 크기의 자료형의 데이터를 작은 크기의 자료형으로 변환하려고 할 때
	 * - 강제 형 변환의 경우 데이터 손실이 발생할 수 있다.
	 * */

	public void casting() {
		double d = 4.12345678901234567890; // double은 소수점 15자리까지만 출력 가능함
		System.out.println(d);
		
		float f = (float) d; // 소수점 6자리까지만 출력 가능함
		System.out.println(f); //강제 형 변환 -> 데이터 손실까지 일어남
		
		int i = (int) f;
		System.out.println(i);
		
		int number = 129;
		// -> byte 값으로 형변환 했을 때 -> 127까지 갔다가 다시 -128로 돌아옴, 그러고 다시 셈을 시작...
		byte b = (byte) number;
		System.out.println(b);
		
		// char <-> int : 각 문자들마다 고유한 숫자가 지정되어 있기 때문 (아스키코드. 유니코드)
		// 쌍방향으로 형변환 가능 (문자를 숫자로, 숫자를 문자로 변환이 가능함)
		// char는 음수값 저장 불가 -> 값의 범위가 0~65535까지
		int num = 'A';
		System.out.println(num);
		
		char ch = 52143;
		System.out.println(ch);
	}
}

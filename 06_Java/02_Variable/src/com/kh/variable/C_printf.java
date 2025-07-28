package com.kh.variable;

public class C_printf {

	public static void main(String[] args) {
		System.out.print("hello"); // 줄바꿈이 포함되어 있지 않음
		// print : 출력만 함 (줄바꿈X) -> 만약 줄바꿈이 하고 싶다..? ("hello\n") 하면 됨
		System.out.println("hello"); // 줄바꿈 포함
		// println : 출력 후 줄바꿈까지!
		
		// printf(출력하고자 하는 형식(포맷), 출력하고자하는 값, 값, ..)
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20%로 표현하고싶음!.!
		System.out.println(iNum1 + "% " + iNum2 + "%");
		// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행
		System.out.printf("%d%% %d%%", iNum1, iNum2);

		
		/*
		 * 포맷에 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능)
		 * */
		System.out.println();
		System.out.printf("%5d\n", iNum1); // 5칸 확보 후 오른쪽 정렬
		System.out.printf("%-5d\n", iNum2); //왼쪽 정렬
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		System.out.printf("%f \t %f \n", dNum1, dNum2); // '%f'만 사용하면 무조건 소수점 아래 6번째 자리까지 출력을 해줄것임
		System.out.printf("%.3f \t %.1f \n", dNum1, dNum2);
		
		char ch = 'a';
		String str = "Hello";
		System.out.printf("%c \t %s \t %s", ch, str, ch);
		System.out.printf("%C %S", ch, str); // 대문자로 출력해줌 %대문자C, %대문자S
				
	}

}

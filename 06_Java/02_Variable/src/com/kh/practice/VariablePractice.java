package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
//		v.method1();
//		v.method2();
//		v.method3();
//		v.method4();
		v.method5();
		v.method6();
		v.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {

		int adult = 10000;
		int teen = 7000;
		
		System.out.println((adult*2)+(teen*3));
        System.out.println("지불할 금액은 총 " + ((adult*2)+(teen*3)) + "원 입니다.");
        System.out.println("\n----------------------------------------------------------");
	}
	
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		// 코드 적어주세요!
		
		final int newx = y;
		final int newy = z;
		final int newz = x;
		
		/*
		 * int temp = x;
		 * x = y;
		 * y = z
		 * z = temp;
		 * */
		
		System.out.println("x =" + newx);
		System.out.println("y =" + newy);
		System.out.println("z =" + newz);
		System.out.println("\n----------------------------------------------------------");
 
	}
	
	

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		
		//정렬 :  내가 정렬하고자 하는 부분 선택하고 Ctrl + Shift + F
		
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n첫 번째 정수 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("두 번째 정수 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int add = num1 + num2;
		
		int sub = num1 - num2;
		
		int multi = num1 * num2;
		
		int division = num1 / num2;
		
		int remain = num1 % num2;
		
		System.out.print("\n더하기 :" + add + "\n빼기 : " + sub + "\n곱하기 : " + multi + "\n나누기 : " + division + "\n나머지 : " + remain);
		System.out.println("\n---ptintf식으로 작성해보기---");
		System.out.printf("\n첫 번째 정수 : %d \n두 번째 정수 :  %d \n더하기 : %d \n빼기 : %d \n곱하기 : %d \n나누기 : %d \n나머지 : %d", num1, num2, add, sub, multi, division, remain);
		System.out.println("\n----------------------------------------------------------");
	}

	/*
	 * 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
Scanner sc = new Scanner(System.in);
		
		System.out.print("\n가로 : ");
		double width = Double.parseDouble(sc.nextLine());
		
		System.out.print("세로 : ");
		double height = Double.parseDouble(sc.nextLine());
		
		double area = width * height;
		double perimeter = (width + height)*2;
		
		System.out.print("\n면적 : " + area + "\n둘레 : " + perimeter );
		//System.out.println("둘레 : " + String.format("%.1f", perimeter))
		System.out.println("\n---ptintf식으로 작성해보기---");
		System.out.printf("\n가로 : %.2f \n세로 : %.2f \n면적 : %.2f \n둘레 : %.1f", width, height, area, perimeter);
		System.out.println("\n----------------------------------------------------------");

	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length()-길이)를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
Scanner sc = new Scanner(System.in);
		
		System.out.print("\n문자열을 입력하세요 : ");
		String input = sc.nextLine();
		
		int length = input.length();
		char firstChar = input.charAt(0);
		char secondChar = input.charAt(1);
		char lastChar = input.charAt(length-1);
		 
		System.out.print("\n첫 번째 문자 : " + firstChar + "\n두 번째 문자 : " + secondChar + "\n마지막 문자: " + lastChar);
		System.out.println("\n---ptintf식으로 작성해보기---");
		System.out.printf("\n첫 번째 문자 : %c \n두 번째 문자 : %c \n마지막 문자 : %c", firstChar, secondChar, lastChar);
		System.out.println("\n----------------------------------------------------------");


	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		
		/*
		 * int num = 'A'
		 * 
		 * */
		 Scanner sc = new Scanner(System.in);
			
			System.out.print("\n문자 하나를 입력하세요 : ");
			char num = sc.nextLine().charAt(0);
			
			int nextch = num;
			System.out.println(num + " unicode : " + nextch);
			System.out.println((char)(nextch+1) + " unicode : " + (nextch+1) );
			System.out.println("\n----------------------------------------------------------");
			
	}
	
	/*
	 *
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		 Scanner sc = new Scanner(System.in);
			
			System.out.print("\n국어 : ");
			double lang = Double.parseDouble(sc.nextLine());
			
			System.out.print("영어 : ");
			double eng = Double.parseDouble(sc.nextLine());
			
			System.out.print("수학 : ");
			double math = Double.parseDouble(sc.nextLine());
			
			double sum = (lang + eng + math);
			double avg = sum / 3;
			
			System.out.print("\n총점 : " + sum + "\n평균 : " + avg);
			System.out.println("\n---ptintf식으로 작성해보기---");
			System.out.printf("\n국어 : %.2f \n영어 : %.2f \n수학 : %.2f \n총점 : %.2f \n평균 : %.2f", lang, eng, math, sum, avg);
			// 조금만 손 대보자.......
	}

}
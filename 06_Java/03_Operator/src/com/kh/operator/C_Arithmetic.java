package com.kh.operator;

public class C_Arithmetic {
	/*
	 * 산술 연산자
	 * + : 더하기
	 * - : 빼기
	 * * : 곱하기
	 * /: 나누기
	 * %: 나머지
	 * */

	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
		c.method2();

	}
    public void method1() {
    	int num1 = 10;
    	int num2 = 3;
    	
    	System.out.println("+ : " + (num1 + num2)); //13
    	System.out.println("- : " + (num1 - num2)); //7
    	System.out.println("* : " + (num1 * num2)); //30 
    	System.out.println("/ : " + (num1 / num2)); //3
    	System.out.println("% : " + (num1 % num2)); //1
    }
    
    //잼따...
    public void method2() {
    	int a = 5;
    	int b = 10;
    	int c = (++a) + b++; // 6+10(11)=16
    	int d = c / a; // 16 / 6 = 2
    	int e = c % a; // 4
    	int f = e++; // 4(5)
        int g = (--b) + (d--); // 10 + 2(1)= 12
        int h = c-- * b; // 16(15) * 10 = 160
        int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); // 
    }           // 6 + 10/ (14/4)*(12 - 1) % (6+160)
                // 6+10/3*11%166
                // 6+3*11%166
                // 6+33%166
                // 6+33
                // 39
    
}

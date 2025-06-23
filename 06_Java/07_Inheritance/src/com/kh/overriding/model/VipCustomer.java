package com.kh.overriding.model;

public class VipCustomer extends Customer { //부모의 객체가 먼저 생성이 되어야 자식이 생성이 된다... extends 걸어두기 전에 부모를 생성해둡시다

	private double saleRatio; // 할인율
	
	public VipCustomer () {}
	
	public VipCustomer(String name) {
		this.name = name;
		this.grade = "VIP";
		this.bonusRatio = 0.1;
		this.saleRatio = 0.5;
	}
	
	public double getSaleRatio() {
		return saleRatio;
	}

	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	
	
	/*
	 * 오버라이딩의 조건
	 * - 부모 클래스의 메서드명, 매개변수, 리턴타입 모두 동일
	 * - 접근제어자를 좁은 범위로 변경할 수 없다 (부모타입이 protected 라면 protected 혹은 public으로 씁니다..)
	 *   -> 부모 클래스 메서드가 protected라면, 범위가 같거나 넓은 protected나 public으로만 변경 가능
	 *   
	 * @Override 어노테이션
	 * - 명시 안 해줘도 오버라이딩됨
	 * - 어노테이션을 붙이는 이유 (실수를 막아내줍니다..오류 잡아줌..)
	 *   -> 해당 메서드가 오버라이딩 된 메서드라는 것을 컴파일러에게 알려주는 역할
	 *   - 자식 메서드에서 재정의를 잘못하나 경우 컴파일 에러 표시
	 * */
	
	@Override
	public void calc(int price) {
		this.bonusPoint = (int) (price * bonusRatio);
		this.price = (int)(price * saleRatio);
	}
		
}

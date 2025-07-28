package com.kh._interface.step2;

public interface RemoteControl extends Volume, Searchable { //인터페이스들끼리는 extends 를 사용합니다...implements는 오류가 납니다..

	void turnOn();
	void turnOff();
}

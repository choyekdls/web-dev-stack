package com.kh._interface.step2;

public interface Volume {
	
	// 변수 앞에 public static final이 붙어있는 것과 같음. (여기서 final은 상수를 의미함..:변화하지 않음)
	// 인터페이스에서 멤버변수는 무조건 상수!
	int MIN_VOLUME = 0;
	int MAX_VOLUME = 20;
	
	// void 앞에 public abstract 가 붙어있는 것과 같음.
	void setVolume(int volume);

}

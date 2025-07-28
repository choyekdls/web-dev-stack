package com.kh.practice.model;

import java.util.Arrays;

public class RockScissorPaper {

	// 캡슐화! -> Single Responsibility Principle (SRP 원칙)
	private String[] rsp = { "가위", "바위", "보" };
	private int win = 0;
	private int lose = 0;
	private int draw = 0;
	public RockScissorPaper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RockScissorPaper(String[] rsp, int win, int lose, int draw) {
		super();
		this.rsp = rsp;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
	}
	public String[] getRsp() {
		return rsp;
	}
	public void setRsp(String[] rsp) {
		this.rsp = rsp;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	@Override
	public String toString() {
		return "RockScissorPaper [rsp=" + Arrays.toString(rsp) + ", win=" + win + ", lose=" + lose + ", draw=" + draw
				+ "]";
	}
	
	
}

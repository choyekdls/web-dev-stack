package com.kh.practice.controller;

import com.kh.array.practice2.model.Member;
import com.kh.practice.model.UserInfo;

public class UserController {

	private UserInfo[] user = new UserInfo[1];

	public void idCheck(String id) {
		for (int i = 0; i < user.length; i++) {
			if (user[i] != null && user[i].getId().equals(id)) {
				// 기존 배열에서 아이디가 있는 경우!
				return;
				
	public UserInfo[] user () {
		return user;
	}
			}
		}
	}
}

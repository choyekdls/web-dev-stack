package controller;

import java.sql.SQLException;

import dao.MemberDAO_T;
import vo.Member_T;

public class MemberController_T {

	private MemberDAO_T dao = MemberDAO_T.getInstance();
	
	// 4. 회원가입
	public String register(Member_T member) {
		try {
			dao.register(member);
			return member.getName() + "님이 회원가입하셨습니다!";
		} catch (SQLException e) {
			return "기존 회원 아이디가 존재합니다. 다른 아이디로 가입해주세요";
		}
	}
	
	// 5. 로그인
	public Member_T login(String id, String pwd) {
		
		try {
			return dao.login(id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 6. 회원탈퇴
	public boolean delete(String id) {
		// 회원탈퇴시 대여중인 책을 모두 기록 삭제
		try {
			dao.delete(id);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}







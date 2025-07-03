package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class MemberController {
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	// 4. 회원가입
	public String register(Member member) throws SQLException {
		
		boolean check = dao.checkId(member.getId(), member.getName(), member.getAge());
		if(check) {
			return "이미 존재하는 회원입니다";
		}
		return dao.register(member);
		// id가 primary key라서 에러가 납니다..활용.. -> 중복 체크를 해준다고...합니다...그런거 모르겠고...
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		return null;
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		// 회원탈퇴 시 대여중인 책을 모두 기록 삭제
	}
	

}

package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.MemberDAO_T;
import vo.Member_T;

class MemberDAOTest {

	private MemberDAO_T dao;

// @BeforeEach : 각 테스트 메서드가 실행되기 전에 무조건 실행
// 보통 DAO나 Service 객체 초기화

	@BeforeEach
	void setUp() {
		dao = MemberDAO_T.getInstance();
	}

	// @AfterEach :  각 테스트 메서드가 실행된 후에 무조건 실행
	@AfterEach
	void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM member").executeUpdate();
	}
	
	@Test
	void testRegister() throws SQLException {
		Member_T member = new Member_T("test01", "테스트01", "pass01", 1);
		dao.register(member);
	}
	
	@Test
	void testLogin() throws SQLException {
		
		Member_T member = new Member_T("test02", "테스트02", "pass01", 1);
		
		member = dao.login("test02", "pass01");
		assertNotNull(member);
	}
	
	@Test
	void testDelete() throws SQLException {
	
		Member_T member = new Member_T("test03", "테스트03", "pass01", 1);
		dao.register(member);
		
		dao.delete("test03");
		
		// 탈퇴했다면 회원이 없겠지?
		member = dao.login("test03", "pass01");
		assertNull(member); // 해당 값이 null일 때 통과
	
	}

}

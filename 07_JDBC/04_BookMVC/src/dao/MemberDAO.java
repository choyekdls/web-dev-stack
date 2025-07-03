package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		try {
		Class.forName(ServerInfo.DRIVER);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	
	// 중복 아이디 이름 나이 체크
	
	public boolean checkId(String id, String name, int age) throws SQLException {
		Connection connect = connect();
		
		String query = "SELECT * FROM member WHERE id = ? AND name = ? AND age = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		
		ResultSet rs = ps.executeQuery();
		return rs.next(); //true 를 리턴합니다..
	}
	
	// 4. 회원가입
	public String register(Member member) throws SQLException {
		
		Connection connect = connect();
		
		String query = "INSERT INTO member VALUES (?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, member.getId()); 
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		
		int result = ps.executeUpdate();
		
		return member.getName() + "님, 회원가입 완료";
		
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) throws SQLException {
		
		Connection connect = connect();
		
		String query = "SELECT * FROM member WHERE id = ? AND pwd = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, pwd);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
		}
		return null;
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		
	}
	

}

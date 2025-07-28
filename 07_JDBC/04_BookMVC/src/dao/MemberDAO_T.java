package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member_T;

public class MemberDAO_T {

	private static MemberDAO_T instance = new MemberDAO_T();

	private MemberDAO_T() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO_T getInstance() {
		return instance;
	}

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 4. 회원가입
	public void register(Member_T member) throws SQLException {
		Connection connect = connect();
		
		String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		
		ps.executeUpdate();
	}

	// 5. 로그인
	public Member_T login(String id, String pwd) throws SQLException {
		Connection connect = connect();
		
		String query = "SELECT * FROM member WHERE id = ? AND pwd = ?";
		PreparedStatement ps = connect.prepareStatement(query);

		ps.setString(1, id);
		ps.setString(2, pwd);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			return new Member_T(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"));
		}
		return null;
	}

	// 6. 회원탈퇴
	public void delete(String id) throws SQLException {
		Connection connect = connect();
		
		String query = "DELETE FROM member WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, id);
		
		ps.executeUpdate();

	}
}

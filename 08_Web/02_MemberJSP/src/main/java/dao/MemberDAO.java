package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	public MemberDAO() {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public Connection connect() throws SQLException {
		// 2. 디비 연결
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/work", "root", "qwer1234");
	}

	// 회원가입
	public void register(Member member) throws SQLException {
		Connection connect = connect();

		String query = "INSERT INTO member VALUES(?, ?, ? , ?)";
		PreparedStatement ps = connect.prepareStatement(query);

		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());

		ps.executeUpdate();
	}

	public List<Member> viewAll() throws SQLException {
		Connection connect = connect();

		String query = "SELECT * FROM member";
		PreparedStatement ps = connect.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		List<Member> list = new ArrayList<>(); // 리스트 만들기

		while (rs.next()) {

			Member member = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"));
			list.add(member); // 리스트에 값 담기
		}
		return list;
	}
	public Member searchMember(String id) throws SQLException {
		Connection connect = connect();
		
		String query = "SELECT * FROM member WHERE id =?";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		Member member = null;
		
		if(rs.next()) {
			member = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"));
		}
		return member;
	}
	
	public void logout() {
		Member member = null;
	}
}
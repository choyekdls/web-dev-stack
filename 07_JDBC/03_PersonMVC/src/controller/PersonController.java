package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class PersonController {

	// 리턴 타입이나 파라미터 자유롭게 변경 가능!
	// 메서드 추가 가능!

	Connection connect;
	PreparedStatement ps;
	ResultSet rs;

	public PersonController() {
		try {
			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// person 테이블에 데이터 추가 - INSERT
	public void addPerson() {

		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);

			String query1 = "INSERT INTO person(name, age, addr)VALUES(?, ?, ?)";
			PreparedStatement ps1 = connect.prepareStatement(query1);

			ps1.setString(1, "최다인");
			ps1.setInt(2, 29);
			ps1.setString(3, "경기도 오산시");

			ps1.executeUpdate();
			
			String query2 = "INSERT INTO person(name, age, addr)VALUES(?, ?, ?)";
			PreparedStatement ps2 = connect.prepareStatement(query2);

			ps2.setString(1, "최혜정");
			ps2.setInt(2, 31);
			ps2.setString(3, "경기도 안산시");

			ps2.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {

		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);

			String query = "SELECT * FROM person";
			ps = connect.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {

				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				System.out.println(name + " / " + age + " / " + addr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로!
	public void searchPerson() {
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);

			int num = 1;

			String query = "SELECT * FROM person WHERE id = ? ";
			ps = connect.prepareStatement(query);

			ps.setInt(1, num);

			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));
				System.out.println(rs.getString("addr"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() {

		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);

			String query = "UPDATE person SET name = ? WHERE name = ? ";
			ps = connect.prepareStatement(query);

			ps.setString(1, "최다희");
			ps.setString(2, "최혜정");

			System.out.println(ps.executeUpdate() + "정보 수정 완료!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson() {
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);

			int num = 2;

			String query = "DELETE FROM person WHERE id = ?";
			ps = connect.prepareStatement(query);

			ps.setInt(1, num);

			System.out.println(ps.executeUpdate() + "데이터 삭제되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

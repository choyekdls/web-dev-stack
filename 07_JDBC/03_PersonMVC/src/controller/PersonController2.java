package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Person;

public class PersonController2 {

	// 리턴 타입이나 파라미터 자유롭게 변경 가능!
	// 메서드 추가 가능!

	Connection connect;
	PreparedStatement ps;
	ResultSet rs;

	public PersonController2() {
		try {
			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 고정적으로 반복 -- 디비 연결
	// 2. 디비 연결
	public Connection getConnect() throws SQLException {
		return connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 오버로딩
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps, connect);
	}

	// ------------------------------ 변동적인 반복 : DAO(Database Access Object)

	// 이름, 나이, 주소가 모드 다 같은 경우 "이미 정보가 있습니다." -> 가입 X
	public boolean checkName(String name, int age, String addr) throws SQLException {
		Connection connect = getConnect();

		String query = "SELECT * FROM person WHERE name = ? AND age = ? AND  addr = ?";
		PreparedStatement ps = connect.prepareStatement(query);

		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);

		ResultSet rs = ps.executeQuery();

		// rs.next() - 존재하면 true, 존재하지 않으면 false
		return rs.next();

	}

	// person 테이블에 데이터 추가 - INSERT
	public String addPerson(String name, int age, String addr) {

		try {

			// 이름, 나이, 주소가 모드 다 같은 경우 "이미 정보가 있습니다." -> 가입 X
			boolean check = checkName(name, age, addr);
			if (check) {
				return "이미 정보가 있습니다.";
			}

			Connection connect = getConnect();

			// 3. PreparedStatement 객체 생성 - 쿼리
			String query = "INSERT INTO person(name, age, addr)VALUES(?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(query);

			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, addr);

			// 4. 쿼리 실행
			int result = ps.executeUpdate();

			// 5. 자원 반납
			close(ps, connect);

			return name + "님, 회원가입 완료";

		} catch (SQLException e) {
			return "회원가입 실패";
		}

	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public List<Person> searchAllPerson() throws SQLException {
		Connection connect = getConnect();

		String query = "SELECT * FROM person";
		ps = connect.prepareStatement(query);

		rs = ps.executeQuery();
		List<Person> list = new ArrayList<>();

		while (rs.next()) {

			Person person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
			list.add(person);
		}
		close(rs, ps, connect);
		return list;
	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로!
	public void searchPerson() throws SQLException {
		Connection connect = getConnect();

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
		close(rs, ps, connect);
	}

	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() throws SQLException {
		Connection connect = getConnect();

		String query = "UPDATE person SET name = ? WHERE name = ? ";
		ps = connect.prepareStatement(query);

		ps.setString(1, "최다희");
		ps.setString(2, "최혜정");

		System.out.println(ps.executeUpdate() + "정보 수정 완료!");

		close(ps, connect);

	}

	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson() throws SQLException {
		Connection connect = getConnect();

		int num = 2;

		String query = "DELETE FROM person WHERE id = ?";
		ps = connect.prepareStatement(query);

		ps.setInt(1, num);

		System.out.println(ps.executeUpdate() + "데이터 삭제되었습니다.");

		close(ps, connect);

	}

}

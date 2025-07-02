package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TransactionTest1 {

	public static void main(String[] args) {
		try {
			Class.forName(ServerInfo.DRIVER);
			Connection connect = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER, ServerInfo.PASSWORD);
			
			// 트랜잭션 시작!
			connect.setAutoCommit(false);
			
			String query1 = "INSERT INTO member VALUES(?, ?, ?)";
			PreparedStatement ps1 = connect.prepareStatement(query1);
			
			ps1.setString(1, "user04");
			ps1.setString(2, "유저");
			ps1.setString(3, "pass01");
			
			ps1.executeUpdate(); // 추가가 되었어요!
			
			String query2 = "SELECT * FROM member WHERE id = ?";
			PreparedStatement ps2 = connect.prepareStatement(query2);
			
			ps2.setString(1, "user04");
			
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) { // 사람이 존재하는 경우
				connect.rollback();
				System.out.println("회원이 존재하여 회원 추가 취소!");
			} else {
				connect.commit();
				System.out.println("회원이 존재하지 않으므로 추가!");
			} 
			// 근데 계속 추가됨..근데 이제 더이상 추가하고 싶지 않은거임.. 트랜잭션 시작을 걸었습니다만...// 트랜잭션 시작! 부분 참고..rollback 과 commit 이 if 문 중간에 추가되었습니다.. 
			// 트랜잭션 끝! 다시 원래대로~
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

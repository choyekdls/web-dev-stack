package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import config.ServerInfo;
import vo.Book;

public class BookDAO {
	
private static BookDAO instance = new BookDAO();
	
	private BookDAO() {
		try {
		Class.forName(ServerInfo.DRIVER);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BookDAO getInstance() {
		return instance;
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		
		Connection connect = connect();
		
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();
		
		while (rs.next()) {
			Book book = new Book(rs.getInt("book_no"), rs.getString("title"), rs.getString("author"), rs.getInt("access_age"));
			
			list.add(book);
		}
		
		return list;
	}
	
	// 책 등록 중복 방지
	public boolean checkBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = connect();
		
		String query = "SELECT * FROM book WHERE title = ? AND author = ? AND access_age = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	
	// 2. 책 등록
	public String registerBook(String title, String author, int accessAge) throws SQLException {
		
		Connection connect = connect();
		
		String query = "INSERT INTO book(title, author, access_age) VALUES (?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, title);
		ps.setString(1, author);
		ps.setInt(1, accessAge);
		
		int result = ps.executeUpdate();
		
		return "책 등록이 완료되었습니다.";
		
	}

	// 3. 책 삭제
	public boolean sellBook(int bookNo) throws SQLException {
		
		Connection connect = connect();
		
		String query = "DELETE FROM book WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setInt(1, bookNo);
		
		ps.executeUpdate();
		
		return true;
		
	}
}

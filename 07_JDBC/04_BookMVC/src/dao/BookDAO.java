package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<Book> printBookAll() throws SQLException {
		
		Connection connect = connect();
		
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		List<Book> list = new ArrayList<>();
		
		while (rs.next()) {
			Book book = new Book(rs.getInt("book_no"), rs.getString("title"), rs.getString("author"), rs.getInt("access_age"));
			
			list.add(book);
		}
		
		return list;
	}
	
	// 2. 책 등록
	public void registerBook(String title, String author, int accessAge) {
		
	}

	// 3. 책 삭제
	public void sellBook(int bookNo) {
		
	}
}

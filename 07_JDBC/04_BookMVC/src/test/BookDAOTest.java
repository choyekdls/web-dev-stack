package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.BookDAO_T;
import vo.Book_T;

public class BookDAOTest {
	
	private BookDAO_T dao;
	
	@BeforeEach
	void setUp() {
		dao = BookDAO_T.getInstance();
	}
		
		@AfterEach
		void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM book").executeUpdate();
	}
	
	
	@Test
	void testRegisterPrint() throws SQLException {
		dao.registerBook("오늘의 낙원에서 만나자", "하태완", 15);
		
		ArrayList<Book_T>list = dao.printBookAll();
		assertEquals(list.get(0).getAuthor(), "하태완");
	}
	
	@Test 
	void sellBook() throws SQLException {
		dao.registerBook("오늘의 낙원에서 만나자", "하태완", 15);
        ArrayList<Book_T> list = dao.printBookAll();
        dao.sellBook(list.get(0).getBookNo());
        list = dao.printBookAll();
        assertEquals(list.size(),0);
        assertTrue(list.isEmpty());
	}

}

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.BookDAO_T;
import dao.MemberDAO_T;
import dao.RentDAO_T;
import vo.Book_T;
import vo.Member_T;
import vo.Rent_T;

class RentDAOTest {

	private RentDAO_T dao;
	private MemberDAO_T member;
	private BookDAO_T book;

	@BeforeEach
	void setUp() {
		dao = RentDAO_T.getInstance();
		member = MemberDAO_T.getInstance();
		book = BookDAO_T.getInstance();

	}

	@AfterEach
	void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM rent").executeUpdate();
		member.connect().prepareStatement("DELETE FROM member").executeUpdate();
		book.connect().prepareStatement("DELETE FROM book").executeUpdate();
	}

	Member_T addMember(String id) throws SQLException {
		Member_T m = new Member_T(id, "테스트02", "pass01", 1);
		member.register(m);
		return member.login(id, "pass01");
	}

	Book_T addBook() throws SQLException {
		book.registerBook("오늘의 낙원에서 만나자", "하태완", 15);
		ArrayList<Book_T> list = book.printBookAll();
		return list.get(0);
	}

	@Test
	void testRent() throws SQLException {
		Member_T member = addMember("test01");
		Book_T book = addBook();

		dao.rentBook(member.getId(), book.getBookNo());
	}
	
	@Test
	void testPrint() throws SQLException {
		Member_T member = addMember("test02");
		Book_T book = addBook();
		dao.rentBook(member.getId(), book.getBookNo());
		
		ArrayList<Rent_T>list = dao.printRentBook(member.getId());
		
		assertEquals(list.size(), 1);
	}

   @Test
   void testDelete() throws SQLException {
	   Member_T member = addMember("test03");
		Book_T book = addBook();
		dao.rentBook(member.getId(), book.getBookNo());
		
		ArrayList<Rent_T>list = dao.printRentBook(member.getId());
		
		dao.deleteRent(list.get(0).getRentNo());
	   
   }

}

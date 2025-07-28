package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import vo.Book;

public class BookController {

	private BookDAO dao = BookDAO.getInstance();

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {

		try {
			return dao.printBookAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// 2. 책 등록
	public String registerBook(String title, String author, int accessAge) {
		// 기존 제목, 저자, 제한 나이까지 동일한 책이 있으면 안되게!
		try {
			boolean check;

			check = dao.checkBook(title, author, accessAge);

			if (check) {
				return "이미 등록이 완료된 책입니다.";
			}

			return dao.registerBook(title, author, accessAge);
		} catch (SQLException e) {
			return "책 등록에 실패하였습니다";
		}
	}

	// 3. 책 삭제
	public String sellBook(int bookNo) {
		// 이미 빌려진 책은 삭제 못하게!
		try {
			if (dao.sellBook(bookNo)) {
				return bookNo + "책이 삭제되었습니다.";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "삭제 실패";
	}
}

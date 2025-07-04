package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO_T;
import dao.RentDAO_T;
import vo.Rent_T;

public class RentController_T {
	
	private RentDAO_T dao = RentDAO_T.getInstance();
	private BookDAO_T bookDao = BookDAO_T.getInstance();
	
	// 로그인된 경우만 접근 가능! -> View에서 조건 걸어서 안보이게 하면 됨!

	// 7. 책 대여
	public boolean rentBook(String id, String title) {
		// 한 사람 당 대여할 수 있는 책은 총 5권
		
		// 중복 책 대여 불가능
		
		// 나이 제한 걸리는 책도 대여 불가능
		
		// 각 책들마다 가능한 대여가 2권까지만 
		
		try {
			dao.rentBook(id, bookDao.searchBook(title));
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	// 8. 내가 대여한 책 조회
	public ArrayList<Rent_T> printRentBook(String id) {
		try {
			return dao.printRentBook(id);
		} catch (SQLException e) {
			return null;
		}
	}
	
	// 9. 대여 취소
	public boolean deleteRent(int rentNo) {
		try {
			dao.deleteRent(rentNo);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	
	
	
	
}

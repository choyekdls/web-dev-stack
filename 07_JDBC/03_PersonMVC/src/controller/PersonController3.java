package controller;

import java.sql.SQLException;
import java.util.List;

import dao.PersonDAO;
import vo.Person;

// DAO - Controller - View 
// Controller 는 중간에서 중간관리자 역할을 합니다.. 
public class PersonController3 {

	private PersonDAO dao = PersonDAO.getInstance();

	// ------- 변동적인 반복 : DAO(Database Access Object)

	public String addPerson(String name, int age, String addr) {

		// 이름, 나이, 주소가 모두 다 같은 경우 "이미 정보가 있습니다." -> 가입 X
		try {

			boolean check = dao.checkName(name, age, addr);
			if (check) {
				return "이미 정보가 있습니다.";
			}
			
			return dao.addPerson(name, age, addr);

		} catch (SQLException e) {
			return "회원가입 실패";
		}
	
	}

	public List<Person> searchAllPerson() {

		try {
			return dao.searchAllPerson();
		} catch (SQLException e) {
			return null;
		}
	}

	public Person searchPerson(int id) {

		try {
		return dao.searchPerson(id);
		} catch (SQLException e) {
			return null;
			}
		}

	public String updatePerson(int id, String name, int age, String addr) {

		try {
			return dao.updatePerson(id, name, age, addr);
		} catch (SQLException e) {
			return "회원 정보 수정에 실패하였습니다";
		}
	}

	public String removePerson(int id) {

		try {
			if(dao.removePerson(id)) {
			return "아이디가 " + id + "인 회원이 삭제되었습니다. 또 만나요:)";
			}
			return "삭제 실패";
		} catch (SQLException e) {
			return "관리자에게 물어보세요";
		}
	}
}

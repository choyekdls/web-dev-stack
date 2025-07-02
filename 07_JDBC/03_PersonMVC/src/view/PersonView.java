package view;

import java.sql.SQLException;

import controller.PersonController;

public class PersonView {
	


	public static void main(String[] args) throws SQLException {
		// 테스트 용도!
		
		PersonController pc = new PersonController();
		
		pc.addPerson();
		pc.searchAllPerson();
		pc.searchPerson();
		pc.updatePerson();
		pc.removePerson();
	}
	
}

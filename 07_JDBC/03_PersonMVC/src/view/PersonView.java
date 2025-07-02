package view;

import controller.PersonController;

public class PersonView {
	


	public static void main(String[] args) {
		
		PersonController pc = new PersonController();
		
		// 테스트 용도!
		
		pc.addPerson();
		pc.searchAllPerson();
		pc.searchPerson();
		pc.updatePerson();
		pc.removePerson();
	}
	
}

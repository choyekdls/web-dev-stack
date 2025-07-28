package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.PersonController2;
import vo.Person;

public class PersonView {

	// 테스트 용도!
	PersonController2 pc = new PersonController2();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PersonView view = new PersonView();

		while (true) {
		
			System.out.println(view.addPerson());

		}
	}
	
	public void menu() {
		while (true) {
			System.out.println("1. 신규 사용자 등록");
			System.out.println("2. 전체 사용자 조회");
			System.out.println("3. 사용자 검색 및 조회");
			System.out.println("4. 사용자 정보 수정");
			System.out.println("5. 사용자 정보 삭제");
			System.out.print("메뉴 번호 입력 : ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1:
				System.out.println(addPerson());
				break;
			case 2:
				System.out.println(searchAllPerson());
				
			}
			}
	}

	public String addPerson() {

		try {
			System.out.println("이름 > ");
			String name = sc.nextLine();
			System.out.println("나이 > ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.println("주소 > ");
			String addr = sc.nextLine();
			return pc.addPerson(name, age, addr);
			// 1인 경우가 추가!

		} catch (NumberFormatException e) {
			return "숫자를 입력해주세요";

		}

		public void searchAllPerson() {
			try {
			List<Person> list = pc.searchAllPerson();
			for(Person p : list) {
				System.out.println(p);
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
		pc.searchPerson();
		pc.updatePerson();
		pc.removePerson();

	}

}

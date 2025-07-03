package view;

import java.util.List;
import java.util.Scanner;

import controller.PersonController3;
import vo.Person;

public class PersonView2 {
	PersonController3 pc = new PersonController3();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PersonView2 view = new PersonView2();
		view.menu();
	}

	public void menu() {
		while (true) {
			System.out.println("1. 신규 사용자 등록");
			System.out.println("2. 전체 사용자 조회");
			System.out.println("3. 사용자 아이디 조회");
			System.out.println("4. 사용자 정보 수정");
			System.out.println("5. 사용자 삭제");
			System.out.print("메뉴 번호 입력 > ");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				System.out.println(addPerson());
				break;
			case 2:
				searchAllPerson();
				break;
			case 3:
				searchPerson();
				break;
			case 4:
				System.out.println(updatePerson());
				break;
			case 5:
				System.out.println(removePerson());
				break;
			default:
				System.out.println("번호를 입력해주세요");
				menu();
				break;
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
		} catch (NumberFormatException e) {
			return "숫자를 입력해주세요:)";
		}
	}

	public void searchAllPerson() {

		List<Person> list = pc.searchAllPerson();
		if (list != null) {
			for (Person p : list) {
				System.out.println(p);
			}
		}
	}

	public void searchPerson() {

		searchAllPerson();

		System.out.println("ID 번호를 입력해주세요");
		int id = Integer.parseInt(sc.nextLine());
		Person person = pc.searchPerson(id);
		if (person != null)
			System.out.println(person + "이 조회되었습니다.");
		else
			System.out.println("존재하지 않는 사용자입니다.");

		// 숫자가 아니면 "번호를 입력해주세요", 번호를 입력했는데 존재하지 않는 데이터면 "존재하지 않은 사용자입니다" 라고 띄우고 싶다..
		// catch 를 하나 더 만들면 되나?
	}

	public String updatePerson() {

		searchAllPerson();

		System.out.print("ID 번호를 입력해주세요 > ");
		int id = Integer.parseInt(sc.nextLine());

		// 아이디가 있는 경우만 수정할 수 있도록!
		Person person = pc.searchPerson(id);
		// 아이디가 없는 경우는 내보내기
		if (person == null)
			return "조회된 사용자가 없습니다";

		System.out.println("이름 > ");
		String name = sc.nextLine();

		System.out.println("나이 > ");
		int age = Integer.parseInt(sc.nextLine());

		System.out.println("주소 > ");
		String addr = sc.nextLine();

		return pc.updatePerson(id, name, age, addr);

	}

	public String removePerson() {

		searchAllPerson();

		System.out.print("ID 번호를 입력해주세요 > ");
		int id = Integer.parseInt(sc.nextLine());

		// 아이디가 있는 경우만 삭제할 수 있도록!
		Person person;
		person = pc.searchPerson(id);
		// 아이디가 없는 경우는 내보내기
		if (person == null)
			return "조회된 사용자가 없습니다";
		return pc.removePerson(id);
	}

}

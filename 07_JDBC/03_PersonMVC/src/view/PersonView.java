package view;

import java.sql.SQLException;
import java.util.Scanner;

import controller.PersonController;

public class PersonView {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		// 테스트 용도!
		
		PersonController pc = new PersonController();

	public void mainMenu() {
		boolean check = true;
		while (check) {
			System.out.println("1. 신규 사용자 등록");
			System.out.println("2. 전체 사용자 조회");
			System.out.println("3. 사용자 검색 및 조회");
			System.out.println("4. 사용자 정보 수정");
			System.out.println("5. 사용자 정보 삭제");
			System.out.print("메뉴 번호 입력 : ");
			int num = Integer.parseInt(sc.nextLine());

			switch (num) {
			case 1:
				addPerson();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}

		}
	}

}

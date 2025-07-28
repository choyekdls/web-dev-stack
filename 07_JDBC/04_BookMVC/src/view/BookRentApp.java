package view;

import java.sql.SQLException;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Member;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체!
	private Member member = null; // 로그인 전 null, 비어있음으로

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {

		BookRentApp app = new BookRentApp();
		app.menu();
	}
	
	
    // 기본메뉴
	public void menu() {
		while (true) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			System.out.print("메뉴 번호 입력 > ");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				printBookAll();
				break;

			case 2:
				register();
				break;

			case 3:
				login();
				break;

			default:
				System.out.println("알맞은 번호를 입력해주세요");
				menu();
				break;
			}
		}
	}

	public void printBookAll() {

	}

	public void register() {
		try {
			Member member = new Member();

			System.out.println("아이디를 입력해주세요");
			member.setId(sc.nextLine());
			System.out.println("이름을 입력해주세요");
			member.setName(sc.nextLine());
			System.out.println("비밀번호를 입력해주세요");
			member.setPwd(sc.nextLine());
			System.out.println("나이를 입력해주세요");
			member.setAge(Integer.parseInt(sc.nextLine()));

			System.out.println(mc.register(member));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void login() {
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.println("비밀번호 > ");
		String pwd = sc.nextLine();
		Member member = mc.login(id, pwd);
		if (member != null) {
			this.member = member;
			System.out.println(member.getName() + "님이 로그인 하셨습니다:)");
		} else {
			System.out.println("로그인 실패! 아이디와 비밀번호를 다시 입력해주세요");
		}
	}

	// 관리자 메뉴
	public void adminMenu() {
		while (true) {
			System.out.println("1. 책 등록하기");
			System.out.println("2. 책 삭제하기");
			System.out.println("3. 로그아웃");
			System.out.println("메뉴 번호 선택 > ");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				registerBook();
				break;

			case 2:
				sellBook();
				break;

			case 3:
				this.member = null;
				menu();
				break;
			}
		}
	}
	
	public void registerBook() {

		System.out.println("등록하실 책 제목을 입력해주세요");
		String title = sc.nextLine();
		System.out.println("등록하실 책의 저자를 입력해주세요");
		String author = sc.nextLine();
		System.out.println("제한 연령 > ");
		int accessAge = Integer.parseInt(sc.nextLine());

		System.out.println(bc.registerBook(title, author, accessAge));
	}
	
	public void sellBook() {
		printBookAll();
		
	}

	// 일반회원 메뉴
	public void clientMenu() {
		while (true) {
			System.out.println("1. 책 대여하기");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.print("메뉴 번호 입력 > ");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				rentBook();
				break;

			case 2:
				printRentBook();
				break;

			case 3:
				deleteRent();
				break;

			case 4:
				this.member = null;
				break;

			case 5:
				delete();
				break;

		

			}
		}
	}

	public void rentBook() {

	}
	
	public void printRentBook() {

	}

	public void deleteRent() {

	}
	
	public void delete() {

	}

	

}

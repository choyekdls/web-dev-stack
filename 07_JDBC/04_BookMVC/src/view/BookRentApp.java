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
	private Member member = new Member();

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {

		BookRentApp app = new BookRentApp();
		app.menu();
	}

	public void menu() {
		while (true) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			System.out.print("메뉴 번호 입력 > ");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				bc.printBookAll();
				menu();
				break;

			case 2:
				register();
				;
				break;
				
			case 3:
				login();
				;
				break;
				
			default:
				System.out.println("알맞은 번호를 입력해주세요");
				menu();
				break;
			}
		}
	}

	public void clientMenu() {
		while (true) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록하기");
			System.out.println("3. 책 삭제하기");
			System.out.println("4. 책 대여하기");
			System.out.println("5. 내가 대여한 책 조회");
			System.out.println("6. 대여 취소");
			System.out.println("7. 로그아웃");
			System.out.print("메뉴 번호 입력 > ");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				bc.printBookAll();
				break;

			case 2:
				bc.registerBook(title, author, accessAge);
				break;

			case 3:
				bc.sellBook(bookNo);
				break;

			case 4:
				rc.rentBook(id, bookNo);
				break;

			case 5:
				rc.printRentBook(id);
				break;

			case 6:
				rc.deleteRent(rentNo);

				break;
				
			case 7:
				System.out.println("로그아웃 되었습니다. 다음에 또 만나요:)");
				menu();

				break;

			default:
				System.out.println("알맞은 번호를 입력해주세요");
				clientMenu();
				break;

			}
		}
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
		
		mc.register(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void login() {
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.println("비밀번호 > ");
		String pwd = sc.nextLine();
		
	}

}

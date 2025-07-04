package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController_T;
import controller.MemberController_T;
import controller.RentController_T;
import vo.Book_T;
import vo.Member_T;
import vo.Rent_T;

public class BookRentApp_T {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체!
	private Member_T member = null; // 로그인 전 null , 비어있음 ~

	private BookController_T bc = new BookController_T();
	private MemberController_T mc = new MemberController_T();
	private RentController_T rc = new RentController_T();

	public static void main(String[] args) {
		BookRentApp_T app = new BookRentApp_T();
		app.menu();
	}

	public void menu() {
		while (true) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			System.out.print("선택 > ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				register();
				break;
			case 3:
				login();
				break;
				}
			}
		}

	// 1. 전체 책 조회
	public void printBookAll() {
		ArrayList<Book_T> list = bc.printBookAll();
		if (list != null) {
			for (Book_T b : list) {
				System.out.println(b);
			}
		} else {
			System.out.println("등록된 책이 없습니다. 관리자에게 문의해주세요:)");
		}

	}

	// 2. 회원가입
	public void register() {

		Member_T member = new Member_T();
		System.out.print("아이디 > ");
		member.setId(sc.nextLine());
		System.out.print("이름 > ");
		member.setName(sc.nextLine());
		System.out.print("비밀번호 > ");
		member.setPwd(sc.nextLine());
		System.out.print("나이 > ");
		member.setAge(Integer.parseInt(sc.nextLine()));

		System.out.println(mc.register(member));
	}

	// 3. 로그인
	public void login() {
		System.out.println("아이디 > ");
		String id = sc.nextLine();
		System.out.println("비밀번호 > ");
		String pwd = sc.nextLine();
		Member_T member = mc.login(id, pwd);
		if (member != null) {
			this.member = member;
			System.out.println(member.getName() + "님이 로그인 하셨습니다:)");
			
			if (member.getId().equals("admin") && member.getPwd().equals("1234")) {
					// 관리자 들어온 경우
					admin();
				} else {
					// 일반 회원인 경우
					menu2();
				}

		} else {
			System.out.println("로그인 실패! 아이디와 비밀번호를 다시 입력해주세요");
		}

	}

	// 관리자로 로그인 했을 때
	// 1. 책 등록 - 로그인 O (관리자 : admin, 1234)
	// 2. 책 삭제 - 로그인 O (관리자 : admin, 1234)
	// 3. 로그아웃 - 로그인 O
	public void admin() {

		System.out.println("1. 신규 도서 등록");
		System.out.println("2. 도서 목록 삭제");
		System.out.println("3. 로그아웃");
		System.out.print("메뉴번호 선택 > ");
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

	// 책 등록
	public void registerBook() {

		System.out.println("동록하실 책 제목을 입력해주세요");
		String title = sc.nextLine();
		System.out.println("등록하실 책의 저자를 입력해주세요");
		String author = sc.nextLine();
		System.out.print("제한 연령 > ");
		int accessAge = Integer.parseInt(sc.nextLine());

		if (bc.registerBook(title, author, accessAge)) {
			System.out.println(title + "책 등록이 완료되었습니다:)");
		} else {
			System.out.println("책 등록에 실패하였습니다. 다시 등록해주세요");
		}
	}

	// 도서 목록 삭제
	public void sellBook() {
		printBookAll();
		System.out.print("삭제할 책 제목을 입력해주세요 > ");
		String title = sc.nextLine();

		if (bc.sellBook(title)) {
			System.out.println(title + "이 삭제되었습니다");
		} else {
			System.out.println("책 삭제에 실패하였습니다.");
		}

	}

	// 일반회원이 들어왔을 때
	// - 로그인 O (관리자 X)
	// - 로그인 O
	// - 로그인 O
	// - 로그인 O
	// - 로그인 O

	public void menu2() {
		System.out.println("1. 회원탈퇴");
		System.out.println("2. 로그아웃");
		System.out.println("3. 책 대여");
		System.out.println("4. 내가 대여한 책 조회");
		System.out.println("5. 대여 취소");
		System.out.print("메뉴 번호 선택 > ");
		int select = Integer.parseInt(sc.nextLine());

		switch (select) {
		case 1:
			delete();
			break;
		case 2:
			this.member = null;
			break;
		case 3:
			rentBook();
			break;
		case 4:
			printRentBook();
			break;
		case 5:
			deleteRent();
			break;
		}
	}

	// 회원탈퇴
	public void delete() {
		mc.delete(this.member.getId());
		this.member = null;

	}

	// 책 대여
	public void rentBook() {
		printBookAll();
		System.out.print("대여할 책 제목을 입력하세요 > ");
		String title = sc.nextLine();
		if(rc.rentBook(this.member.getId(), title)) {
			System.out.println(this.member.getName() + "님이 " + title + "을 대여 완료하였습니다:)");
		} else {
			System.out.println("책 대여에 실패하였습니다;(");
		}

	}

	// 내가 대여한 책 조회
	public void printRentBook() {
		
		ArrayList<Rent_T> list = rc.printRentBook(this.member.getId());
		for(Rent_T r : list) {
			System.out.println(r.getBook());
		}

	}

	// 대여 취소
	public void deleteRent() {
		
		ArrayList<Rent_T> list = rc.printRentBook(this.member.getId());
		for(Rent_T r : list) {
			System.out.println(r);
		}
		System.out.println("대여 취소할 책 번호 입력 > ");
		int rentNo = Integer.parseInt(sc.nextLine());
		rc.deleteRent(rentNo);

	}

}

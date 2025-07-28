package com.kh.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class Application {

	Scanner sc = new Scanner(System.in);
	// 로그인된 정보가 들어가는 곳!
	Member m = null;

	// 멤버들의 정보가 들어갈 공간
	ArrayList<Member> members = new ArrayList<>();

	// 대여 가능한 책 목록
	ArrayList<Book> books = new ArrayList<>();
	{
		books.add(new Book("디스 이즈 이탈리아", false, 0));
		books.add(new Book("리얼 런던", true, 0));
		books.add(new Book("집에서 즐기는 스페인 요리 여행", false, 0));
		books.add(new Book("사퀴트리 샌드위치", false, 0));
		books.add(new Book("원피스 111", true, 15));
		books.add(new Book("귀멸의 칼날 23", false, 19));
		books.add(new Book("진격의 거인 Before the fall 16", false, 19));
	}

	public static void main(String[] args) {

		Application app = new Application();

		// 사용자한테 입력받기 (public void login() {})
		app.login();
	}

	// 기존 회원이 아니면 값이 저장 되면서 로그인 성공
	// 이름 나이 다 입력했는데 이름이 중복되면 "이미 존재하는 이름입니다. 다시 입력해주실래요?" 하고 다시 이름 입력란으로 돌아가기
	// if(로그인 성공 시) {"ㅇㅇ님! 환영합니다!" 메세지와 함께 메인메뉴 보이기}

	public void login() {
		Member m = new Member();
		System.out.println("이름 : ");
		m.setName(sc.nextLine());
		System.out.println("나이 : ");
		m.setAge(Integer.parseInt(sc.nextLine()));
		for (Member member : members) {
			if (m.getName().equals(member.getName())) {

				if (m.getAge() == member.getAge()) {
					System.out.println(m.getName() + "님, 환영합니다!");
					this.m = member;
					mainMenu();
				} else {
					System.out.println("이미 존재하는 이름입니다. 다시 입력해주실래요?");
					login();
				}
			}
		}
		members.add(m); // 회원가입과 동시에
		System.out.println(m.getName() + "님, 환영합니다!");
		this.m = m; // 로그인!
		mainMenu();
	}

	public void mainMenu() {
		boolean check = true;
		while (check) {
			System.out.println(" === 메뉴 === ");
			System.out.println("1. 마이페이지");
			// myPage();
			System.out.println("2. 대여하기");
			// bookShelf();
			System.out.println("3. 로그아웃");
			// logOut(); 로그인으로 다시 돌아가기
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int num = Integer.parseInt(sc.nextLine());

			switch (num) {
			case 1:
				myPage();
				break;
			case 2:
				bookShelf();

				break;
			case 3:
				// 로그인화면으로 돌아가기
				Logout();
				break;
			case 4:
				// "이용해주셔서 감사합니다:)" 메세지와 함께 종료
				System.out.println("이용해주셔서 감사합니다:)");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				// 메인메뉴로 이동 try ~ catch
			}
		}
	}

	public void myPage() {
		System.out.println(m);
	}

	public void bookShelf() {
		// 대여가능한 책 목록 보이기
		// System.out.println(books);
		// 3권 다 대여된 책은 목록에서 삭제하기(가능할가..?)

		// 1. 한 사람 당 대여할 수 있는 책은 총 3권 "더 이상 대여할 수 없습니다."
		// -> if(대여책목록 < 3) {책 대여 가능, 멤버 북리스트에 추가하기}
		// else {system 어쩌구 ("더 이상 대여할 수 없습니다.")}
		// 2. 이미 대여한 책은 대여 불가능 "이미 대여한 책입니다."
		// -> if(대여책목록 == 책) {system 어쩌구 ("이미 대여한 책입니다.")}
		// else {대출가능}
		// 3. 나이 제한에 걸리는 책들 대여 불가능 "나이 제한으로 대여 불가능합니다."
		// -> if(사용자 나이 < 책 제한 나이) {system 어쩌구 ("나이 제한으로 대여 불가능합니다.")}
		// else {대출가능}
		// 4. 쿠폰이 있는 경우 나이제한 걸려도 대여 가능 (True인 책들을 대여하면 쿠폰을 준다는 것 같음)
		// -> (선택사항) 5. 각 책들마다 가능한 대여가 3권까지만(각 책들의 보유수량이 3개라는 뜻인듯) HashMap ->
		// getOrDefault(키, 초기값) -> 대여 가능한 경우 : "성공적으로 대여되었습니다."
		//

		for (int i = 0; i < books.size(); i++) {
			System.out.println(i + "번째 : " + books.get(i));
		}
		System.out.print("책 번호 : ");
		int select = Integer.parseInt(sc.nextLine());
		Book b = books.get(select); // 인덱스만 있으면 책 한 권 가지고 올 수 있으니까!

		// 1. 한 사람당 대여 가능한 책은 총 3권
		if (m.getBookList().size() > 2) {
			System.out.println("더 이상 대여할 수 없습니다.");
		} else if (m.getBookList().equals(books)) {
			System.out.println("이미 대여한 책입니다.");// 2. 이미 대여한 책은 대여 불가능
		} else if (m.getAge() < b.getAccessAge()) {
			if (m.getCoupon() == 0) {
				System.out.println("나이 제한으로 대여 불가능합니다.");
			} else {
				m.setCoupon(m.getCoupon() - 1);
				m.getBookList().add(b);
			}
		} else { // 대여 가능!
			if (b.isCoupon())
				m.setCoupon(m.getCoupon() + 1); // 책에 쿠폰이 true 즉 있는 경우만!
			m.getBookList().add(b);
		}
	}

	public void Logout() {
		this.m = null; // 로그인 된 정보 비우기!
		login();
	}

}

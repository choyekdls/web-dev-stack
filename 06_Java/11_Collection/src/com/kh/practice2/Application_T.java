package com.kh.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice2.Controller.BookController;
import com.kh.practice2.Controller.MemberController;
import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class Application_T {

	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	BookController bc = new BookController();

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
		Application_T app = new Application_T();

		try {
			app.menu();
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다! 다시 입력해주세요:)");
			app.menu();
		}
	}

	Member member;

	public void menu() {
		try {
			member = new Member();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			boolean result = mc.registerAndLogin(name, age);
			if (!result) {
				System.out.println("이미 존재하는 이름입니다. 다시 입력해주세요:0");
				menu();
			}

		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다! 다시 입력해주세요ㅠㅠ");
			menu();
		}

		boolean check = true;

		while (check) {
			System.out.println(" ==== 메뉴 ==== ");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 로그아웃");
			System.out.println("4. 프로그램 종료");
			System.out.println("번호: ");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				System.out.println(mc.getMember()); // 입력과 동시에 멤버에 담긴 이름과 나이 불러오기
				break;
			case 2:
				rent();
				break;
			case 3:
				mc.logout();
				menu(); // 다시 로그인 화면으로 돌아가기
				break;
			case 4:
				check = false;
				break;

			}
		}
	}

	public void rent() {
		// 도서 대여하기
		/*
		 * for(Book book : books) { System.out.println(book);// 향상된 for 문은 인덱스를
		 * 못찾습니다...값만 가지고 올 때만 간단합니다...! 인덱스가 필요하면 일반 for 문으로 진행하는 것이 좋습니다.. }
		 */
		for (int i = 0; i < books.size(); i++) {
			System.out.println(i + "번째 " + books.get(i));
		}
		System.out.println("대여할 책 번호 선택 : ");
		int select = Integer.parseInt(sc.nextLine());

		Object result = bc.rentBook(books.get(select), mc.getMember());
		if(result instanceof Member) {
			System.out.println("성공적으로 대여되었습니다.");
			mc.setMember((Member)result);
		} else {
			System.out.println(result);
		}
		}

}

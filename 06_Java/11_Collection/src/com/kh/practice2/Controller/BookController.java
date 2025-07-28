package com.kh.practice2.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class BookController {

	private Map<String, Integer> bookCount = new HashMap<>();
	
	MemberController mc = new MemberController();
	
	public Object rentBook(Book book, Member member) {
		// 내 책 리스트
		ArrayList<Book> list = member.getBookList();
		
		// 1. 한 사람 당 대여할 수 있는 책은 총 3권
		if(list.size() > 2) {
		return "더이상 대여할 수 없습니다.";
		}
		
		// 2. 해당 사람이 대여한 책은 대여 불가능
		// 기존 list에 해당 책이 있는 경우 대여 못하게! return
		if(list.contains(book)) {
			return "이미 대여한 책입니다.";
		}
		
		// 3. 나이 제한에 걸리는 책들 대여 불가능 (쿠폰이 없는 경우)
		if(member.getCoupon() == 0 && member.getAge() < book.getAccessAge()) {
			return "나이 제한으로 대여 불가능합니다.";
		}
		
		// 5. 각 책들마다 가능한 대여가 3권까지만 (사람이 여러명인 경우)
		if (book.getCount() > 2) {
			return "더 이상 이 책은 대여할 수 없습니다.";
		}
		
		
		// 대여 가능!--------------------------------------------------
		
		// Book 객체에 count 추가한 방법
		// 대여를 할 때마다 Book count 가 하나씩 추가되도록
		book.setCount(book.getCount() + 1);
		
		// 책에 쿠폰이 있는 경우 -> 내 쿠폰 하나 추가
		if(book.isCoupon()) {
			member.setCoupon(member.getCoupon() + 1); 
		}
		// 4. 쿠폰이 있는 경우 나이 제한 걸려도 대여 가능
		if(member.getAge() < book.getAccessAge()) {
			// 쿠폰을 사용! 멤버가 가지고 있는 쿠폰에서 - 1
			member.setCoupon(member.getCoupon() - 1);
		  		
		}	
		// 대여 가능!
		list.add(book);
		member.setBookList(list);
		return member;
		//member.getBookList().add(book);
		
				
	}
}

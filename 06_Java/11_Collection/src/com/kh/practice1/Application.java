package com.kh.practice1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Application {

	static Random random = new Random();

	public static void main(String[] args) {
		int[] result = new int[4];
		// index : 0 - 2등, 1 - 3등, 2 - 4등, 3 - 5등, 

		// 1등 당첨 기준이 로도 번호 6개
		// 둘 다 랜덤! 로또 번호는 1번!
		// 내 번호는 맞출때까지!!
		// 로또 번호는 1 ~ 45

		// 로또번호
		// set 을 list 로 바꿀 때 -> List<Integer> lottoList = new ArrayList<>(lotto);

		int count = 0;
		int bonusnum = random.nextInt(1, 46);
		boolean check = true;
		
		

		Set<Integer> lotto = new TreeSet<Integer>();
		
		// 2등 당첨! 보너스 번호가 일치 + 5개가 같은 경우
		// 3등 당첨! 5개만 같은 경우
		// 4등 당첨! 4개만 같은 경우
		// 5등 당첨! 3개만 같은 경우

		//TreeSet은 SubList 못쓰나..?
		while (lotto.size() < 6) {
			lotto.add(random.nextInt(1, 46));
		}
		    lotto.add(bonusnum);

		Set<Integer> myList = new TreeSet<Integer>();

		while (check) { // 왜 또 갑자기...랜덤으로 숫자가 안뽑히는 거야..
						
			while (myList.size() < 6) {
				myList.add(random.nextInt(1, 46));
			}
			count++;
			int num = 0;
			Iterator<Integer> lt = lotto.iterator();
			Iterator<Integer> ml = myList.iterator();
			for(int i = 0; i < myList.size(); i++) {
				if(lt.next() == ml.next()) {
					num++;
				}
			}
			System.out.println("로또 번호 : " + lotto);
			System.out.println("내 번호 : " + myList);
			if (lotto.equals(myList)) { //lotto는 7자리고 myList는 6자리인데 이렇게 하면..평생 1등 당첨될 일 없는 것 아님..?
				check = false;
				System.out.println("1등 당첨! 도전 횟수 : " + count);	
				for(int i = 0; i < result.length; i++) {
					System.out.println((i + 2) + "등 횟수 : " + result[i] + "회");
				}
				break;
			} else if (myList.contains(bonusnum) && num == 5) {
				System.out.println("2등 당첨! 도전 횟수 : " + count);
				result[0]++;
			} else if (num == 5) { 
				System.out.println("3등 당첨! 도전 횟수 : " + count);
				result[1]++;
			} else if (num == 4){
				System.out.println("4등 당첨! 도전 횟수 : " + count);
				result[2]++;
			} else if (num == 3){
				System.out.println("5등 당첨! 도전 횟수 : " + count);
				result[3]++;
				}else {myList.clear();}
			}
		}
	}

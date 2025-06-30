package com.kh.practice3.controller;

import java.util.ArrayList;

import com.kh.practice3.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();
	Music m;
	
	//1. 특정 곡 추가
	public String addList() {
		for (Music music : list) {
			if (m.getSong().contains(music.getSong())) {
				this.m = new Music();
				return "플레이리스트에 이미 존재하는 곡입니다.";
				} 
		}
		list.add(m);
		return "플레이리스트에 추가하였습니다.";	
	}
	
	//2. 전체 곡 목록 출력
	public void printAll() {
		
	}
	
	//3. 특정 곡 검색
	public void searchMusic(String song) {
		for(Music music : list) {
			if(song.contains(m.getSong())) {
				System.out.println(m.getArtist() + " - " + m.getSong() + " 을 검색했습니다.");
				System.out.println(m.getSong().contains(song));
			} else {
				System.out.println("검색할 곡을 찾지 못했습니다.");
			}
		}
	}
	
	//4. 특정 곡 수정
	public void updateMusic() {
		
	}
	
	//5. 특정 곡 삭제
	public void removeMusic() {
		
	}
	
}
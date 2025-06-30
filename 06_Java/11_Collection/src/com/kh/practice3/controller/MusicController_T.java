package com.kh.practice3.controller;

import java.util.ArrayList;

import com.kh.practice3.model.Music;

public class MusicController_T {

	private ArrayList<Music> list = new ArrayList<>();
	Music m;
	
	//1. 특정 곡 추가
	public void addList(String song, String artist) {
		list.add(new Music(song, artist));
				} 
	
	//2. 전체 곡 목록 출력
	public ArrayList<Music> printAll() {
		return list;
	}
	
	//3. 특정 곡 검색
	// equals 는 완전히 똑같게 써야하고, contains 는 일부만 같아도 ok 입니다..
	// 하지만 contains 를 쓸 때는 대소문자를 일치시켜줘야합니다... .toLowerCase는 소문자~
	public Music searchMusic(String keyword) {
		for(Music music : list) {
			if(music.getSong().toLowerCase().contains(keyword.toLowerCase())) {
				return music;
			}
		}
		return null;
	}
	
	//4. 특정 곡 수정
	public Music updateMusic(String searchSong, Music update) {

		for(Music music : list) {
			if(music.getSong().equals(searchSong)) {
				return list.set(list.indexOf(music), update);
			}
		}
		return null;
	}
	
	//5. 특정 곡 삭제
	public Music removeMusic(String song) {
		for (Music music : list) {
			if(music.getSong().equals(song)) {
				return list.remove(list.indexOf(music));
			}
		}
		return null;
	}
	
}
package com.kh.paging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.mapper.FilmMapper;
import com.kh.paging.model.vo.Film;

@Service
public class FilmService { 
	// implements 걸어도 됨 -> Override 적으면 됨

	@Autowired
	private FilmMapper mapper;
	
	public List<Film> showFilm(PagingDTO paging) {
		/*
		 * 만약 limit 이 10인 경우
		 * page = 1 -> offset = 0
		 * page = 2 -> offset = 10
		 * page = 3 -> offset = 20
		 * 
		 * offset = limit * (page - 1)
		 * */
		paging.setOffset(paging.getLimit() * (paging.getPage()-1));
		return mapper.showFilm(paging);
	}
}

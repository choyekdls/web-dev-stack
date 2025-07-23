package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.model.vo.Film;
import com.kh.paging.service.FilmService;


@Controller
public class FilmController {

	@Autowired
	private FilmService service;

	//session 에 담은 값은 서버가 종료될 때까지, model 에 담은 값은 한 번 보내고 끝
	@GetMapping("/list")
	public String showFilm(Model model, PagingDTO paging) {
				
		List<Film> list = service.showFilm(paging);
        model.addAttribute("list", list);
        model.addAttribute("paging",new PagingDTO(paging.getPage(), service.total()));
        return "list";
		
        //model.addAttribute("list", service.showFilm(paging));
		//model.addAttribute("paging",paging, service.total());
		//return "list";
	}		
}
		
package com.kh.paging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.paging.service.FilmService;


@Controller
public class FilmController {

	@Autowired
	private FilmService service;
	
	@GetMapping("/list")
	public String showFilm(Model model) {
		model.addAttribute("list",service.showFilm());
		return "list";
	}
		
	}


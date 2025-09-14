package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("component", "../component/main.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/example")
	public String example(Model model) {
		model.addAttribute("component", "../component/example.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/allMember")
	public String allMember(Model model) {
		model.addAttribute("component", "../component/allMember.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/insertSalary")
	public String insertSalary (Model model) {
		model.addAttribute("component", "../component/insertSalary.jsp");
		return "/common/layout";
	}
}

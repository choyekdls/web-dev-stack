package com.project.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.erp.model.vo.Sale;
import com.project.erp.service.SaleService;

@Controller
public class FinancialController {

	@Autowired SaleService saleService;
	
	@PostMapping("/insert")
	public String insert(Sale sale) {
		saleService.addSale(sale);
		return "redirect:/list";
	}
	
	
	
	@GetMapping("/list")
	public String list() {
		List<Sale> list = saleService.viewSale();
		System.out.println(list);
		return "redirect:/";
	}
	
}

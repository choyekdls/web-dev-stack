package com.project.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.mapper.SaleMapper;
import com.project.erp.model.vo.Sale;

@Service
public class SaleService {

	@Autowired
	private SaleMapper mapper;

	public void addSale(Sale sale) {
		
		
	}

	public List<Sale> viewSale() {
		
		return null;
	}
	
	
}

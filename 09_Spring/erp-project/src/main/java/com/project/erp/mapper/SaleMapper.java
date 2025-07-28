package com.project.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.erp.model.vo.Sale;

@Mapper
public interface SaleMapper {
void addSale(Sale sale);
List<Sale> viewSale();

}

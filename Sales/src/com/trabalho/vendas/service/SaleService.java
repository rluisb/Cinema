package com.trabalho.vendas.service;

import java.util.List;

import javax.inject.Inject;

import com.trabalho.vendas.entity.Sale;
import com.trabalho.vendas.repository.SaleRepository;
import com.trabalho.vendas.transactional.Transacional;

public class SaleService {

	@Inject
	private SaleRepository saleRepository;
	
	@Transacional
	public void save(Sale sale) {
		if (sale.getId() == null) {
			saleRepository.save(sale);
		} else {
			saleRepository.update(sale);
		}
	}

	@Transacional
	public List<Sale> listAllRecords() {
		return saleRepository.listAll();
	}

	@Transacional
	public void delete(Sale sale) {
		saleRepository.delete(sale);
	}
	
	@Transacional
	public Sale findByID(Integer id) {
		return saleRepository.findByID(id);
	}
	
}

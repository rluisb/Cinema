package com.trabalho.vendas.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.trabalho.vendas.entity.Sale;
import com.trabalho.vendas.service.SaleService;

@Path("/venda")
@Produces({ "application/json" })
public class SaleFacade {

	@Inject
	private SaleService saleService;
	
	@GET
	@Path("/todos")
	public List<Sale> listAll() {
		return saleService.listAllRecords();
	}
	
	@GET
	@Path("/buscar/{id}")
	public Sale oneClient(@PathParam("Venda") Integer id) {
		return saleService.findByID(id);
	}
	
	@POST
	@Path("/salvar")
	public void save(Sale sale) {
		saleService.save(sale);
	}

	@DELETE
	@Path("/deletar/{id}")
	public void delete(@PathParam("Venda") Integer id) {
		saleService.delete(saleService.findByID(id));
	}
	
}

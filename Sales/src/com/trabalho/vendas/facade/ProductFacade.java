package com.trabalho.vendas.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.trabalho.vendas.entity.Product;
import com.trabalho.vendas.service.ProductService;

@Path("/produto")
@Produces({ "application/json" })
public class ProductFacade {

	@Inject
	private ProductService productService;
	
	@GET
	@Path("/todos")
	public List<Product> listAll() {
		return productService.listAllRecords();
	}
	
	@GET
	@Path("/buscar/{id}")
	public Product oneClient(@PathParam("Produto") Integer id) {
		return productService.findByID(id);
	}
	
	@POST
	@Path("/salvar")
	public void save(Product product) {
		productService.save(product);
	}

	@DELETE
	@Path("/deletar/{id}")
	public void delete(@PathParam("Produto") Integer id) {
		productService.delete(productService.findByID(id));
	}
	
}

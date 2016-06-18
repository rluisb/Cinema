package com.trabalho.vendas.model.controller;

import javax.inject.Inject;

import com.trabalho.vendas.model.repository.ProductRepository;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
@Path("/produto")
public class ProductController {

	@Inject
    private Result result;
    @Inject
    private ProductRepository productRepository;
 
    @Get
    @Path("/listadeprodutos")
    public void listAll() {
        result.use(Results.json())
            .withoutRoot()
            .from(productRepository.list())
            .serialize();
    }
	
}

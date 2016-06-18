package com.trabalho.vendas.model.controller;

import javax.inject.Inject;

import com.trabalho.vendas.model.repository.SaleRepository;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
@Path("/venda")
public class SaleController {

	@Inject
    private Result result;
    @Inject
    private SaleRepository saleRepository;
 
    @Get
    @Path("/listadevendas")
    public void listAll() {
        result.use(Results.json())
            .withoutRoot()
            .from(saleRepository.list())
            .serialize();
    }
	
}

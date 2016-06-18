package com.trabalho.vendas.model.controller;

import javax.inject.Inject;

import com.trabalho.vendas.model.repository.ClientRepository;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
@Path("/cliente")
public class ClientController {

	@Inject
    private Result result;
    @Inject
    private ClientRepository clientRepository;
 
    @Get
    @Path("/listadeclientes")
    public void listAll() {
        result.use(Results.json())
            .withoutRoot()
            .from(clientRepository.list())
            .serialize();
    }
	
}

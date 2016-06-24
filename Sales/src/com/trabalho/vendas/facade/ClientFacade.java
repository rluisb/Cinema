package com.trabalho.vendas.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.trabalho.vendas.entity.Client;
import com.trabalho.vendas.service.ClientService;

@Path("/cliente")
@Produces({ "application/json" })
public class ClientFacade {

	@Inject
	private ClientService clientService;
	
	@GET
	@Path("/")
	public List<Client> listAll() {
		return clientService.listAllRecords();
	}
	
	@GET
	@Path("/{id}")
	
	public Client oneClient(@PathParam("Cliente") Integer id) {
		return clientService.findByID(id);
	}
	
	@POST
	@Path("/")
	public void save(Client client) {
		clientService.save(client);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("Cliente") Integer id) {
		clientService.delete(clientService.findByID(id));
	}
}

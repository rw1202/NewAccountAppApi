package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.new_account.AccountRepo;


@Path ("/account")

public class AccountEndpoint {
	
	
	@Inject
	private AccountRepo service;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@Path("/getAccount/{Id}")
	@GET
	@Produces({ "application/json" })
	public String getAccount(@PathParam("Id") Long Id) {
		return service.getAccount(Id);
	}

	@Path("/addAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.addAccount(account);
	}

	@Path("/deleteAccount/{Id}")
	@GET
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("Id") Long Id) {
		return service.deleteAccount(Id);
	}
	@Path("/updateAccount/{Id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("Id") Long Id, String account ) 
	{
		return service.updateAccount(Id, account);
	}

	public void setService(AccountRepo service) {
		this.service = service;
	}

}






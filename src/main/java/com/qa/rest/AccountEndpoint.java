package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.new_account.repository.ClassRoomRepo;


@Path ("/Classroom")

public class AccountEndpoint {
	
	
	@Inject
	private ClassRoomRepo service;

	@Path("/getAllRooms")
	@GET
	@Produces({ "application/json" })
	public String getAllRooms() {
		return service.getAllRooms();
	}
	
	@Path("/getRoom/{Id}")
	@GET
	@Produces({ "application/json" })
	public String getRoom(@PathParam("Id") Long Id) {
		return service.getRoom(Id);
	}

	@Path("/addRoom")
	@POST
	@Produces({ "application/json" })
	public String addRoom(String account) {
		return service.addRoom(account);
	}

	@Path("/deleteRoom/{Id}")
	@GET
	@Produces({ "application/json" })
	public String deleteRoom(@PathParam("Id") Long Id) {
		return service.deleteRoom(Id);
	}
	@Path("/updateRoom/{Id}")
	@PUT
	@Produces({"application/json"})
	public String updateRoom(@PathParam("Id") Long Id, String account ) 
	{
		return service.updateRoom(Id, account);
	}

	public void setService(ClassRoomRepo service) {
		this.service = service;
	}

}






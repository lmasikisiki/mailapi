package com.leetech.apis.mailapi.rest;

import javax.ws.rs.Produces;

import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailApiController {
	
	@Autowired
	private CommandBus CommandBus;

	@GetMapping(value = "/home")
	@Produces("application/json")
	public String home() {
		return "welcome";
	}
}

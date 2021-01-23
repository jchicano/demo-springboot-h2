package io.github.jchicano.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.jchicano.model.Account;
import io.github.jchicano.serv.AccountService;

@RestController
public class AccountController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	@Autowired
	AccountService service;

	// Save account entity in the h2 database.
	@PostMapping(value= "/account/save")
	public int save(final @RequestBody Account acc) {
		log.info("Saving account details in the database.");
		service.save(acc);
		return acc.getId();
	}

	// Get all accounts from the h2 database.
	@GetMapping(value= "/account/getall", produces= "application/vnd.jcg.api.v1+json")
	public List<Account> getAll() {
		log.info("Getting account details from the database.");
		return service.getAll();
	}

}
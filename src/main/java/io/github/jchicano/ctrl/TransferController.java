package io.github.jchicano.ctrl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.github.jchicano.model.Transfer;
import io.github.jchicano.serv.TransferService;

@RestController
public class TransferController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	@Autowired
	TransferService service;

	@PostMapping(value= "/transfers")
	public Optional<Transfer> createTransfer(final @RequestBody Transfer transfer) throws Exception {
		try {
//			return this.service.createTransfer(transfer.getSource().getId(), 2, 1);
			return this.service.createTransfer(1,1,10);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}
	
	@GetMapping(value = "/transfers/{number}", produces= "application/vnd.jcg.api.v1+json")
	public Transfer findTransaction(final @PathVariable("number")Long id) throws Exception {
		log.error("TEST");
		log.error(id+"");
		try {
            return this.service.findTransfer(id)
                    .orElseThrow(() -> new Exception("Transfer with id " + id + " does not exists"));
        } catch (final Exception e) {
        	log.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
	}

//	// Get all accounts from the h2 database.
//	@GetMapping(value= "/account/getall", produces= "application/vnd.jcg.api.v1+json")
//	public Iterable<Account> getAll() throws Exception {
//		log.info("Getting account details from the database.");
//		return service.getAll();
//	}
	
}

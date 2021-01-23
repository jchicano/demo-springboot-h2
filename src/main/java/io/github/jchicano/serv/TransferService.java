package io.github.jchicano.serv;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jchicano.ctrl.AccountController;
import io.github.jchicano.model.Account;
import io.github.jchicano.model.Transfer;
import io.github.jchicano.repo.AccountRepository;
import io.github.jchicano.repo.TransferRepository;

@Service
public class TransferService {
	@Autowired
	TransferRepository repository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
    private AccountRepository accountRepository = null;
	@Autowired
    private TransferRepository transferRepository = null;
	
	public Optional<Transfer> createTransfer(final int i, final int j, final int amount) throws Exception {
        try {
        	System.out.println(amount);

        	final Account sourceAccount = this.accountService.findAccount(i)
                    .orElseThrow(() ->
                            new Exception("The source account " + i + " does not exists."));
            final Account targetAccount = this.accountService.findAccount(j)
                    .orElseThrow(() ->
                            new Exception("The target account " + j + " does not exists."));

            sourceAccount.giveBalance(amount);
            targetAccount.receiveBalance(amount);
            
            final Transfer transfer = new Transfer(sourceAccount, targetAccount, amount);

            final Account updatedSourceAccount = this.accountRepository.save(sourceAccount);
            final Account updatedTargetAccount = this.accountRepository.save(targetAccount);

            final Transfer newTransfer = this.transferRepository.save(transfer);

            log.info("Transfer " + newTransfer.getId() + " created. Subtracted " + amount + " money from " + updatedSourceAccount.getId() + " and added to " + updatedTargetAccount.getId());

            return Optional.of(newTransfer);
        } catch (final Exception e) {
        	log.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

	public Optional<Transfer> findTransfer(Long id) throws Exception {
        try {
            return this.transferRepository.findById(id);
        } catch (final Exception e) {
            throw new Exception("Transfer with id " + id +" not found", e);
        }
    }
}

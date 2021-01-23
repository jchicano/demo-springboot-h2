package io.github.jchicano.serv;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jchicano.model.Account;
import io.github.jchicano.repo.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository repository;

	// Save account entity in the h2 database.
	public void save(final Account acc) {
		repository.save(acc);
	}
	
	public Optional<Account> findAccount(int sourceAccountId) {
		final Optional<Account> account = repository.findById(sourceAccountId);
		return account;
	}

	// Get all accounts from the h2 database.
	public List<Account> getAll() {
		final List<Account> accounts = new ArrayList<>();
		repository.findAll().forEach(acc -> accounts.add(acc));
		return accounts;
	}
}

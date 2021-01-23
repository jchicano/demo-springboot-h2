package io.github.jchicano.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.jchicano.model.Account;


@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{

}

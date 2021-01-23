package io.github.jchicano.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.jchicano.model.Transfer;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {

}

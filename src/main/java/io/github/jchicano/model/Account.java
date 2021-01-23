package io.github.jchicano.model;

import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private int id;
    private String name;
    private Currency currency;
    private int balance;
    private boolean treasury;
}

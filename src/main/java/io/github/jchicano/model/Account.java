package io.github.jchicano.model;

import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;


@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String name;
    private String currency;
    private int balance;
    private boolean treasury;
    
	public Account(int id, String name, String currency, int balance, boolean treasury) {
		super();
		this.id = id;
		this.name = name;
		this.currency = currency;
		this.balance = balance;
		this.treasury = treasury;
	}
	
	public Account() {
		super();
	}
	
	public void giveBalance(final @NonNull int amount) throws Exception {
        if (this.treasury == false) {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount must be > 0");
            }
        }

        final int newBalance = balance -= amount;

        if (this.treasury == false) {
            if (newBalance < 0) {
                throw new Exception("Balance will be negative, transaccion stopped.");
            }
        }

        this.balance = newBalance;
    }

    public void receiveBalance(final @NonNull int amount) {
        if (this.treasury == false) {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount must be > 0");
            }
        }
        this.balance = this.balance += amount;
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public boolean isTreasury() {
		return treasury;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", currency=" + currency + ", balance=" + balance
				+ ", treasury=" + treasury + "]";
	}
    
    
}

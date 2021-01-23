package io.github.jchicano.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transfer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private Account source;

    @ManyToOne
    @JoinColumn(name = "target_id", nullable = false)
    private Account target;

    private int amount;

	public Transfer(Account source, Account target, int amount) {
		super();
		this.source = source;
		this.target = target;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public Account getSource() {
		return source;
	}

	public Account getTarget() {
		return target;
	}

	public int getAmount() {
		return amount;
	}
	
    
}

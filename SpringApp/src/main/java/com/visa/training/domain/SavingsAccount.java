package com.visa.training.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SA")
public class SavingsAccount extends Account{

	public SavingsAccount() {
		super();
		
	}

	public SavingsAccount(float balance) {
		super(balance);
		
	}

	@Override
	public String toString() {
		return "SavingsAccount [id=" + id + ", balance=" + balance + "]";
	}
	
	

}

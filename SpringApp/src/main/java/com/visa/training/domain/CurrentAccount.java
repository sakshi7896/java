package com.visa.training.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account {
	
	@Column(name= "OD_limit")
	float odLimit;
	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(float balance, float odLimit) {
		super(balance);
		this.odLimit=odLimit;
		// TODO Auto-generated constructor stub
	}

	public float getODLimit() {
		return odLimit;
	}

	public void setODLimit(float oDLimit) {
		this.odLimit = oDLimit;
	}

	@Override
	public String toString() {
		return "CurrentAccount [odLimit=" + odLimit + ", id=" + id + ", balance=" + balance + "]";
	}

	
	
	
}

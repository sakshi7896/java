package com.visa.training.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity // tells this class is mapped
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String firstname;
	String middlename;
	String lastname;
	Date dateofjoin;
	@OneToMany(mappedBy= "customer")
	//@JoinColumn- can do without mappedby also
	List<Account> accounts= new ArrayList<Account>();

	public Customer(String firstname, String middlename, String lastname, Date dateofjoin) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofjoin = dateofjoin;
	}

	public Customer() {

	}

	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public java.sql.Date getDateofjoin() {
		return dateofjoin;
	}

	public void setDateofjoin(java.sql.Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname="
				+ lastname + ", dateofjoin=" + dateofjoin + "]";
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}

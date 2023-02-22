package com.example.demo.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BankManagementSystem")
public class BankCustomerEntity {

	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public Long id;
	
	@Column(name="User Name")
	public String name;
	
	@Column(name="Date Of Birth")
	public Date dob;
	
	@Column(name="Email Id")
	public String emails;
	
	@Column(name = "Passwords")
	public String passwords;
	
	@Column(name="balance")
	public double balance;

	public BankCustomerEntity(){
		
	}

	public BankCustomerEntity(String name, Date dob, String emails, String passwords, double balance) {
		super();
		this.name = name;
		this.dob = dob;
		this.emails = emails;
		this.passwords = passwords;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

	
}

package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.BankCustomerEntity;

public interface ServiceInterface {

	public BankCustomerEntity createCustomer(BankCustomerEntity bankCustomerEntity); 
	
	public List<BankCustomerEntity> findAllCustomer();
	
	public boolean checkCustomer(String name);
	
	public double getBalance(String name);
	
	public boolean checkCustomer(String name, String password);
}

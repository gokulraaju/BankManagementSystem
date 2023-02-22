package com.example.demo.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.BankCustomerEntity;
import com.example.demo.Repository.BankCustomerRepository;
import com.example.demo.Service.ServiceInterface;

@Service
public class ServiceImplementation implements ServiceInterface{

	@Autowired
	BankCustomerRepository bankCustomerRepository;
	
	@Override
	public BankCustomerEntity createCustomer(BankCustomerEntity bankCustomerEntity) {
		return bankCustomerRepository.save(bankCustomerEntity);
	}

	@Override
	public List<BankCustomerEntity> findAllCustomer() {
		return bankCustomerRepository.findAll();
	}

	@Override
	public boolean checkCustomer(String name) {
		boolean check = false;
		List<BankCustomerEntity> list = findAllCustomer();
		for(BankCustomerEntity user:list) {
			String currName = user.getName();
			if(currName.equals(name)) {
				check = true;
			}
		}
		return check;
	}

	@Override
	public double getBalance(String name) {
		double  balance = 0.0;
		List<BankCustomerEntity> list = findAllCustomer();
		for(BankCustomerEntity user : list) {
			String currName = user.getName();
			if(currName.equals(name)) {
				balance = user.getBalance();
			}
		}
		return balance;
	}

	@Override
	public boolean checkCustomer(String name, String password) {
		boolean check = false;
		List<BankCustomerEntity> list = findAllCustomer();
		for(BankCustomerEntity user:list) {
			String currName = user.getName();
			String currPswd = user.getPasswords();
			if(currName.equals(name) && currPswd.equals(password)) {
				check = true;
			}
		}
		return check;
	}
}

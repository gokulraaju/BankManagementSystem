package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.BankCustomerEntity;
import com.example.demo.Service.Implementation.ServiceImplementation;

@Controller
public class BankController {

	@Autowired
	ServiceImplementation serviceImplementation;
	
	@GetMapping("/welcome")
	public String welcomePage() {
		return "WelcomePage";
	}
	
	@GetMapping("/welcome/createAccount")
	public String createCustomer(Model model) {
		BankCustomerEntity bankCustomerEntity = new BankCustomerEntity();
		model.addAttribute("bankCustomerEntity",bankCustomerEntity);
		return "CreateCustomer";
	}
	
	@PostMapping("/welcome")
	public String saveCustomerCreatingAcc(@ModelAttribute("bankCustomerEntity") BankCustomerEntity bankCustomerEntity) {
		
		boolean check = serviceImplementation.checkCustomer(bankCustomerEntity.getName());
		if(check) {
			return "AccountNotCreated";
		}
		else {
			serviceImplementation.createCustomer(bankCustomerEntity);
			return "AccountCreatedSuccessful";
		}
	}
	
	@GetMapping("/welcome/login")
	public String loginPage(Model model) {
		BankCustomerEntity bankCustomerEntity = new BankCustomerEntity();
		model.addAttribute("bankCustomerEntity",bankCustomerEntity);
		return "LoginPage";
	}
	
	@PostMapping("/welcome/login")
	public String BalancePage(@ModelAttribute("bankCustomerEntity") BankCustomerEntity bankCustomerEntity,Model model) {
		
		boolean check = serviceImplementation.checkCustomer(bankCustomerEntity.getName(),bankCustomerEntity.getPasswords());
		System.out.println(check);
		if(check) {
			double balance = serviceImplementation.getBalance(bankCustomerEntity.getName());
			System.out.println(balance);
			model.addAttribute("Balance",balance);
			return "Balance";
		}
		else {
			return "NoExistingAccount";
		}
	}
}

package com.autentia.accountdemo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.accountdemo.domain.Account;
import com.autentia.accountdemo.security.domain.CurrentUser;
import com.autentia.accountdemo.security.domain.UserDetails;



@RestController
@RequestMapping(value = "/api/accounts")
public class AccountResource {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Account> getAccounts(@CurrentUser UserDetails userDetails) {
		Account a = new Account(UUID.randomUUID().toString() + " user account " + createUserAppendix(userDetails));
		Account b = new Account(UUID.randomUUID().toString() + " user account " + createUserAppendix(userDetails));
		
		List<Account> accounts = new ArrayList<>();
		accounts.add(a);
		accounts.add(b);
		
		return accounts;
	}
	
	private String createUserAppendix(UserDetails userDetails) {
		return userDetails.getFullName() + " (id= " + userDetails.getId() + ")";
	}
	
}
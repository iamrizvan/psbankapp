package com.riz.dev.psbankapp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riz.dev.psbankapp.dao.AccountDAO;
import com.riz.dev.psbankapp.model.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
	

	public AccountServiceImpl() {
	}

	@Autowired
	AccountDAO accountDAO;
	
	@Override
	@Transactional
	public boolean saveAccount(Account account) {
		return false;
	}

	

}

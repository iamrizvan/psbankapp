package com.riz.dev.psbankapp.services;


import org.springframework.stereotype.Service;

import com.riz.dev.psbankapp.model.Account;

@Service
public interface AccountService {
	public boolean saveAccount(Account account);
}

 package com.riz.dev.psbankapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.riz.dev.psbankapp.entity.AccountEntity;
import com.riz.dev.psbankapp.model.Account;


@Repository 
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public boolean saveAccount(Account account) {
		boolean saveFlag = true;
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccNo(account.getAccountNo());
		accountEntity.setAccHolderName(account.getAccountHolderName());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setAccountType(account.getAccountType());
	    accountEntity.setDateOfBirth(account.getDateOfBirth());
		accountEntity.setPsCode(account.getPsCode());
		try {
			Session currentSession = sessionfactory.getCurrentSession();
			currentSession.save(accountEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

}

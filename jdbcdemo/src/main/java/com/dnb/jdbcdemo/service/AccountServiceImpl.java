package com.dnb.jdbcdemo.service;

import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.repo.AccountRepository;
import com.dnb.jdbcdemo.repo.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService {

	private static AccountService accountService = null;
	

	private AccountServiceImpl() {

	}

	public static AccountService getInstance() {
		synchronized (AccountServiceImpl.class) {
			if (accountService == null) {
				accountService = new AccountServiceImpl();
			}
		}

		return accountService;
	}

	@Override
	public Account createAccount(Account account) {
		AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
		return accountRepository.createAccount(account);
	}

	@Override
	public Optional<Account> getAccountById(String accountId) {
		AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
		return accountRepository.getAccountById(accountId);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		AccountRepository accountRepository=AccountRepositoryImpl.getInstance();
		return accountRepository.getAllAccounts();
	}
}

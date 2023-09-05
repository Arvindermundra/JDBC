package com.dnb.jdbcdemo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.dnb.jdbcdemo.dto.Account;
import com.dnb.jdbcdemo.repo.AccountRepositoryImpl;
import com.dnb.jdbcdemo.service.AccountService;
import com.dnb.jdbcdemo.service.AccountServiceImpl;

public class JDBCApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// localdate to sql date:java.sql.date

		Scanner sc = new Scanner(System.in);
//		List<Account> accounts = new ArrayList<>();
//		//int n = sc.nextInt();
//		for (int i = 0; i < 1; i++) {
//		Account newAccount = new Account();
//		newAccount.setAccountId(sc.next());
//		newAccount.setAccountHolderName(sc.next());
//		newAccount.setAccountType(sc.next());
//		newAccount.setBalance(sc.nextFloat());
//		newAccount.setContactNumber(sc.next());
//		newAccount.setAddress(sc.next());
//		newAccount.setAccountCreatedDate(LocalDate.now());
//		newAccount.setDob(LocalDate.now());
//		newAccount.setAccountStatus(true);
//		Account account = AccountServiceImpl.getInstance().createAccount(newAccount);
//
//		accounts.add(newAccount);
//		}
//
//
//		accounts.forEach(account -> {
//			AccountServiceImpl.getInstance().createAccount(account);
//		});
//		

		int choice = -1;
		do {
			System.out.println("Enter your choice : \n" + "1. Create Account \n" + "2. Search Account \n" + "3. Get All Accounts \n"+"4. Exit");
			choice = sc.nextInt();

			if (choice < 1 || choice > 4) {
				System.out.println("Enter correct ");
				continue;
			}

			switch (choice) {
			case 1:
				createAccount();
				break;

			case 2:
				getAccount();
				break;

			case 3:
				getAllAccounts();

			}

		} while (choice != 3);

	}

	private static void getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = new ArrayList<>();
		
	}

	public static void createAccount() {
		List<Account> accounts = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many account you want to create : ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Account newAccount = new Account();
			System.out.println("Account Id : ");
			newAccount.setAccountId(sc.next());

			System.out.println("Account Holder Name : ");
			newAccount.setAccountHolderName(sc.next());

			System.out.println("Account Type : ");
			newAccount.setAccountType(sc.next());

			System.out.println("Balance : ");
			newAccount.setBalance(sc.nextFloat());

			System.out.println("Contact Number : ");
			newAccount.setContactNumber(sc.next());

			System.out.println("Address : ");
			newAccount.setAddress(sc.next());

			System.out.println("DOB : ");
			String dob = sc.next();
			newAccount.setDob(convertToLocalDate(dob));

//          System.out.println("Account Status : ");
			newAccount.setAccountStatus(true);

			accounts.add(newAccount);
		}

		accounts.forEach(account -> {
			AccountServiceImpl.getInstance().createAccount(account);
		});
	}

	private static LocalDate convertToLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(date, formatter);
	}

	public static void getAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account Id");
		String accountId = sc.next();
		Optional<Account> result = AccountServiceImpl.getInstance().getAccountById(accountId);

		if (result.isPresent()) {
			Account account = result.get();
			System.out.println(account.getAccountId() + " " + account.getAccountHolderName() + " "
					+ account.getAccountType() + " " + account.getBalance() + " " + account.getAccountCreatedDate()
					+ " " + account.getDob() + " " + account.isAccountStatus());
		} else {
			System.out.println("No account found for this " + accountId + " account id.");
		}
	}

}
package com.capgemini.bankapp.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import org.springframework.stereotype.Repository;


import com.capgemini.bankapp.entities.BankAccount;
import com.capgemini.bankapp.repository.BankAccountRepository;
@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {
	String getBankData;

	public BankAccountRepositoryImpl(String getBankData) {
		getBankData = "select * from bankData";
	}
	
	private HashSet<BankAccount> bankAccounts;
	
		public BankAccountRepositoryImpl() {
		bankAccounts=new HashSet<>();
		bankAccounts.add(new BankAccount(1234,"malyka","saving",30000));
		bankAccounts.add(new BankAccount(1235,"sameera","saving",35000));
		bankAccounts.add(new BankAccount(1234,"poudel","saving",40000));
		
	}
		

	@Override
	public double getBalance(long accountId) {
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId() == accountId)
				return bankAccount.getAccountBalance();
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountId() == accountId) {
				bankAccount.setAccountBalance(newBalance);
				return true;
			}
		}
		return false;
	}

}
	

	
	

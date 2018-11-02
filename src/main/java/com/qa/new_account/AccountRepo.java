package com.qa.new_account;

public interface AccountRepo {

	String getAllAccounts();

	String addAccount(String Account);

	String deleteAccount(Long Id);

	String getAccount(Long Id);

	String updateAccount(Long Id, String account);

	


}

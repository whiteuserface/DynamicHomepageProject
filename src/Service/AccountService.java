package Service;

import java.util.ArrayList;
import java.util.List;

import Dao.AccountDao;
import Entity.Account;

public class AccountService {
	AccountDao ad = new AccountDao();
	public void insert(Account account) {
		ad.insertAccount(account);
	}
	
	public List<Account> getBusi_numAccountList(String findBusi_num) {
		List<Account> list = new ArrayList<>();
			list = ad.getBusi_numAccountList(findBusi_num);
		return list;
	}
	
	public void accountDelete(String busi_num) {
		ad.deleteBusi_num(busi_num);
	}

	public List<Account> getCustomSearchList(String custom) {
		return ad.getCustomSearchList(custom);
	}
	
	public Account getBusi_numAccount(String busi_num) {
		return ad.getBusi_numAccount(busi_num);
	}
	
	public void updateAccount(Account account) {
		ad.updateAccount(account);
	}
	
}

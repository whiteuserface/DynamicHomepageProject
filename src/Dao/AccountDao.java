package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Account;
import Entity.Custom;

public class AccountDao {
	public void insertAccount(Account account) {
		String sql =
				"insert into \"ACCOUNT\"(busi_num, factory, trade_bank, account_num) values (?, ?, ?, ?)";
					
				
				String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
					PreparedStatement ps = con.prepareStatement(sql);
					
					ps.setString(1, account.getBusi_num());
					ps.setString(2, account.getFactory());
					ps.setString(3, account.getTrade_bank());
					ps.setString(4, account.getAccount_num());
					
					ps.executeUpdate();
					
					con.close();
					ps.close();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	public List<Account> getBusi_numAccountList(String Busi_num) {
		List<Account> list = new ArrayList<>();
		String sql =
				"select * from busi_num_account where trim(busi_num) like '%"+Busi_num+"%'";
					
				Account account = new Account();
				account = null;
				
				String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					ResultSet rs = null;
					Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
					Statement st = con.createStatement();
					rs = st.executeQuery(sql);
					
					while(rs.next()) {
						String busi_num = rs.getString("busi_num");
						String factory = rs.getString("factory");
						String trade_bank = rs.getString("trade_bank");
						String account_num = rs.getString("account_num");
						account = new Account(busi_num, factory, trade_bank, account_num);
						list.add(account);
					}
					con.close();
					st.close();
					rs.close();
					if(list.size() != 0) {
						return list;						
					}
					
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return list;
	}

	public void deleteBusi_num(String busi_num) {
		String sql =
				"delete account where trim(busi_num) = ?";
					
				String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					
					Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
					PreparedStatement ps = con.prepareStatement(sql);
					
					ps.setString(1, busi_num);
					ps.executeQuery();
					
					con.close();
					ps.close();
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
	}

	public List<Account> getCustomSearchList(String custom) {
		List<Account> list = new ArrayList<>();
		String sql =
				"select * from account_custom_view where custom='%"+custom+"%'";
				Account account = null;
				
				String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					ResultSet rs = null;
					Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
					Statement st = con.createStatement();
					rs = st.executeQuery(sql);
					
					while(rs.next()) {
						String busi_num = rs.getString("busi_num");
						String factory = rs.getString("factory");
						String trade_bank = rs.getString("trade_bank");
						String account_num = rs.getString("account_num");
						account = new Account(busi_num, factory, trade_bank, account_num);
						list.add(account);
					}
					con.close();
					st.close();
					rs.close();
					if(list.size() != 0) {
						return list;						
					}
					
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list;
		
	}

	public Account getBusi_numAccount(String busi_num) {
		String sql =
				"select * from account where trim(busi_num) = ?";
				Account account = null;
				
				String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					ResultSet rs = null;
					Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, busi_num);
					rs = ps.executeQuery();
					
					if(rs.next()) {
						String businum = rs.getString(1);
						String factory = rs.getString(2);
						String trade_bank = rs.getString(3);
						String account_num = rs.getString(4);
						account = new Account(businum, factory, trade_bank, account_num);
					}
					con.close();
					ps.close();
					rs.close();
					if(account != null) {
						return account;
					}
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return account;
		
	}
	
	public void updateAccount(Account account) {
				account.setBusi_num(account.getBusi_num().trim());
		String sql =
				"update account set busi_num = ?, factory = ?, trade_bank = ?, account_num = ? where rtrim(busi_num) = ?";
					
				
				String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
					PreparedStatement ps = con.prepareStatement(sql);
					
					ps.setString(1, account.getBusi_num());
					ps.setString(2, account.getFactory());
					ps.setString(3, account.getTrade_bank());
					ps.setString(4, account.getAccount_num());
					ps.setString(5, account.getBusi_num());
					
					ps.executeUpdate();
					
					con.close();
					ps.close();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
}

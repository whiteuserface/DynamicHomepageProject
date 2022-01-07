package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Account;
import Service.AccountService;

@WebServlet("/insertaccount")
public class insertaccountController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		AccountService as = new AccountService();
		
		String busi_num_account = request.getParameter("busi_num_account");
		String factory = request.getParameter("factory");
		String trade_bank = request.getParameter("trade_bank");
		String account_num = request.getParameter("account_num");
		
		Account account = new Account(busi_num_account, factory, trade_bank, account_num);
		
		as.insert(account);
		
		response.sendRedirect("/addall");
	}
}

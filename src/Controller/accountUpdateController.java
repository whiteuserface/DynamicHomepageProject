package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Account;
import Service.AccountService;
@WebServlet("/accountupdate")
public class accountUpdateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountService as = new AccountService();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String busi_num = request.getParameter("busi_num");
		String factory = request.getParameter("factory");
		String trade_bank = request.getParameter("trade_bank");
		String account_num = request.getParameter("account_num");
		
		Account account = new Account(busi_num,factory,trade_bank,account_num);
		
		as.updateAccount(account);
		
		response.sendRedirect("/addall");
	}
}

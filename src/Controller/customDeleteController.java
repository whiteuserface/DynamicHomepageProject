package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.AccountService;
import Service.CustomService;
@WebServlet("/delete")
public class customDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		CustomService cs = new CustomService();
		AccountService as = new AccountService();
		String busi_num = request.getParameter("busi_num");
		cs.deleteCustom(busi_num);
		as.accountDelete(busi_num);
		response.sendRedirect("/addall");
	}
}

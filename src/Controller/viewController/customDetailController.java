package Controller.viewController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Account;
import Entity.BusiNum_Custom;
import Entity.Custom;
import Service.AccountService;
import Service.CustomService;

@WebServlet("/customdetail")
public class customDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountService as = new AccountService();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
			
			
		request.getRequestDispatcher("/view/customdetail.jsp").forward(request, response);
		
	}
}

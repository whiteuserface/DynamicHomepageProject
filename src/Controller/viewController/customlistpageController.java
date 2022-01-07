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
import Entity.Custom;
import Service.AccountService;
import Service.CustomService;

@WebServlet("/customlist")
public class customlistpageController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		CustomService cs = new CustomService();
		AccountService as = new AccountService();
		Custom tmp = null;
		Account act = null;
		String busi_num = "";
		String custom = "";
		String busi_num_ = request.getParameter("busi_num");
		String custom_ = request.getParameter("custom");
		List<Custom> customList = new ArrayList<>();
		List<Account> accountList = new ArrayList<>();
		
		if((busi_num_ !=null && busi_num != "")&&(custom_ != null && custom_ != "")) {
			busi_num = busi_num_;
			custom = custom_;
			customList = cs.getBusi_numSearchList(busi_num_);
			accountList = as.getBusi_numAccountList(busi_num) ;
			request.setAttribute("customList",customList);
			request.setAttribute("accountList",accountList);
			request.getRequestDispatcher("/view/customlist.jsp").forward(request, response);
		}
		else if(busi_num_ != null && busi_num_ !="") {
			busi_num = busi_num_;
			customList = cs.getBusi_numSearchList(busi_num);
			accountList = as.getBusi_numAccountList(busi_num);
			request.setAttribute("customList",customList);
			request.setAttribute("accountList",accountList);
			request.getRequestDispatcher("/view/customlist.jsp").forward(request, response);
			
		} else if(custom_ !=null && custom_ !="") {
			custom = custom_;
			customList = cs.getCustomSearchList(custom);
			accountList = as.getCustomSearchList(custom);
			request.setAttribute("customList",customList);
			request.setAttribute("accountList",accountList);
			request.getRequestDispatcher("/view/customlist.jsp").forward(request, response);
		
		} else {
			response.sendRedirect("/addall");
		}
		//√ ±‚»≠
		busi_num = "";
		custom = "";
		busi_num_ = "";
		custom_ = "";
		customList = null;
		accountList = null;
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
	}
}

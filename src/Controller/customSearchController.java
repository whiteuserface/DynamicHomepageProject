package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Custom;
import Service.CustomService;
@WebServlet("/search")
public class customSearchController extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		CustomService cs = new CustomService();
		String busi_num = "";
		String custom = "";
		String busi_num_ = request.getParameter("busi_num");
		String custom_ = request.getParameter("custom");
		if((busi_num_!="" && custom_!="")&&(busi_num_!=null && custom_!=null)) {
			busi_num = busi_num_;
			custom = custom_;
			response.sendRedirect("/customlist?busi_num="+busi_num+"&custom="+custom);
		} else if(busi_num_!= "" && busi_num_!=null) {
			busi_num = busi_num_;
			response.sendRedirect("/customlist?busi_num="+busi_num);
		} else if(custom_ != "" && custom_!=null) {
			custom = custom_;
			response.sendRedirect("/customlist?custom="+custom);
		} else {
			response.sendRedirect("/addall");
		}
	}
}

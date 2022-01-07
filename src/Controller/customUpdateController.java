package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Custom;
import Service.CustomService;

@WebServlet("/customupdate")
public class customUpdateController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		
		CustomService cs =new CustomService();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		
		String busi_num = request.getParameter("busi_num"); //1
		String custom = request.getParameter("custom"); //2
		
		String short_ = request.getParameter("short_"); //3
		
		String ceo = request.getParameter("ceo"); //4
		
		String charge_person = request.getParameter("charge_person"); //5
		
		String busi_condition = request.getParameter("busi_condition"); //6
		
		String item = request.getParameter("item"); //7
		
		String post_num = request.getParameter("post_num"); //8
		
		String addr1 = request.getParameter("addr1"); //9
		String addr2 = request.getParameter("addr2"); //10
		String tel = request.getParameter("tel"); //11
		
		String fax = request.getParameter("fax"); //12
		
		String homepage = request.getParameter("homepage"); //13
		
		String co_yn = request.getParameter("co_yn"); //14
		
		String foreign_yn = request.getParameter("foreign_yn"); //15
		
		String tax_yn = request.getParameter("tax_yn"); //16
		
		String country_eng = request.getParameter("country_eng"); //17
		
		String country_kor = ""; //18
		try {
			if(country_eng != null && country_eng != "") {
				String[] eng_kor = country_eng.split(" "); //split해서
				country_eng = eng_kor[1];// 첫번째것은 country_eng
				country_eng.trim();
				country_kor = eng_kor[0]; //18 두번째것은 country_kor로 넣는다.
				country_kor.trim();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		String special_relation = request.getParameter("special_relation"); //19
		
		String trade_stop = request.getParameter("trade_stop"); //20
		
		String contract_period_s = request.getParameter("contract_period_s"); //21
		
		String contract_period_e = request.getParameter("contract_period_e"); //22
		
		String modi_info_man = request.getParameter("modi_info_man"); //23
	
		
		Custom newCustom = new Custom( busi_num,  custom,  short_,  ceo,  charge_person,
				 busi_condition,  item,  post_num,  addr1,  addr2,  tel,  fax,
				 homepage,  co_yn,  foreign_yn,  tax_yn,  country_eng,  country_kor,
				 special_relation,  trade_stop,  contract_period_s,  contract_period_e,
				 modi_info_man);
		busi_num.trim();
		cs.updateCustom(newCustom, busi_num);
		
		response.sendRedirect("/addall");
		
//		response.encodeRedirectUrl("/customdetail");
//		request.getRequestDispatcher("/view/custominsert.jsp").forward(request, response);
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}

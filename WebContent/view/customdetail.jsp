<%@page import="Entity.DetailEntity"%>
<%@page import="Service.DetailService"%>
<%@page import="Service.AccountService"%>
<%@page import="Entity.BusiNum_Custom"%>
<%@page import="Service.CountryService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.Account"%>
<%@page import="Entity.Custom"%>
<%@page import="java.util.List"%>
<%@page import="Service.CustomService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customdetailpage</title>
</head>
<body>
<a href="/addall">홈으로가기</a>
<div>HEADER</div>
	
	

	<form action="/customlist" method="post">
			<div><label>사업자번호</label></div>
			<div><input type="text" name="busi_num" /></div>
			<div><label>거래처명</label></div>
			<div><input type="text" name="custom" /></div>
			<div><button type="submit">검색</button></div>
	</form>
	<label>전체목록</label>
		<%
		CustomService cs = new CustomService();
		ArrayList<BusiNum_Custom> customList = cs.getAllBusi_num_Custom();
		%>
			<%for (int i=0; i<customList.size(); i++) { %>
				<div>	
						<a href="/customdetail?busi_num=<%=customList.get(i).getBusi_num()%>">
							<label for="msg">회사명:</label>
							<span><%=customList.get(i).getBusi_num()%></span>
						</a>	
				</div>
				<div>
						<a href="/customdetail?busi_num=<%=customList.get(i).getBusi_num()%>">
							<label for="msg">거래처명:</label>
							<span><%=customList.get(i).getCustom()%></span>
						</a>
						<br>
				</div>
				<br>
			<%} %>
			
			
		<%
			DetailService ds = new DetailService();
			String busi_num = request.getParameter("busi_num");
		 	DetailEntity de = ds.getDetailEntity(busi_num); 
		%>

<div>

	<form action="/customupdate" method="post">
	
    <div>
        <label for="msg">사업자번호:</label>
        <input type="" name="busi_num" readonly="readonly" value="<%=de.getBusi_num()%>" />
    </div>
    <div>
        <label for="msg">거래처명:</label>
        <input type="text" name="custom" value="<%=de.getCustom()%>" />
    </div>
    <div>
        <label for="msg">약칭:</label>
        <input type="text" name="short_" value="<%=de.getShort_()%>" />
    </div>
    <div>
        <label for="msg">대표자:</label>
        <input type="text" name="ceo" value="<%=de.getCeo()%>" />
    </div>
    <div>
        <label for="msg">담당자:</label>
        <input type="text" name="charge_person" value="<%=de.getCharge_person()%>"/>
    </div>
    <div>
        <label for="msg">업 태:</label>
        <input type="text" name="busi_condition" value="<%=de.getBusi_condition()%>" />
    </div>
    <div>
        <label for="msg">종 목:</label>
        <input type="text" name="item" value="<%=de.getItem()%>" />
    </div>
    
    <input type="hidden" id="confmKey" name="confmKey" value=""/>
		<table>
			<colgroup>
				<col style="width:20%"><col>
			</colgroup>
			<tbody>
				<tr>
					<th>우편번호</th>
					<td>
					    <input type="hidden" id="confmKey" name="" value=""  >
						<input type="text" id="zipNo" name="post_num" style="width:100px" value="<%=de.getPost_num()%>" >
						<input type="button"  value="주소검색" onclick="goPopup();">
					</td>
				</tr>
				<tr>
					<th>도로명주소</th>
					<td><input type="text" id="roadAddrPart1" name="addr1" style="width:85% " value="<%=de.getAddr1()%>" ></td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td>
						<input type="text" id="addrDetail" style="width:40%" value="상세주소" name="addr2" value="<%=de.getAddr2()%>" >
						<input type="text" id="roadAddrPart2"  style="width:40%">
					</td>
				</tr>
			</tbody>
		</table>
    <div>
        <label for="msg">전화번호:</label>
        <input type="tel" name="tel" value="<%=de.getTel()%>" />
    </div>
    <div>
        <label for="msg">팩스번호:</label>
        <input type="tel" name="fax" value="<%=de.getFax()%>" />
    </div>
    <div>
        <label for="msg">홈페이지:</label>
        <input type="url" name="homepage" value="<%=de.getHomepage()%>" />
    </div>
    <div>
        <label for="msg">법인여부:</label>
        <%if(de.getCo_yn().equals("y")) { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="co_yn" checked="checked"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="co_yn"/>
        <% } else if(de.getCo_yn().equals("n")) {%>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="co_yn"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="co_yn" checked="checked"/>
        <%} else {%>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="co_yn"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="co_yn"/>
        <%}%>
    </div>
    <div>
        <label for="msg">해외여부:</label>
        <%if(de.getForeign_yn().equals("y")) { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="foreign_yn" checked="checked" />
        <label for="msg">n:</label>
        <input type="radio" value="n" name="foreign_yn"/>
        <%} else if(de.getForeign_yn().equals("n")) { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="foreign_yn"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="foreign_yn" checked="checked" />
        <%} else { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="foreign_yn"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="foreign_yn"/>
        <%}%>
    </div>
    <div>
        <label for="msg">과세구분:</label>
        <%if(de.getTax_yn().equals("y")) { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="tax_yn" checked="checked" />
        <label for="msg">n:</label>
        <input type="radio" value="n" name="tax_yn"/>
        <%} else if(de.getTax_yn().equals("n")) { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="tax_yn"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="tax_yn" checked="checked" />
        <%} else { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="tax_yn"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="tax_yn"/>
        <%}%>
    </div>
    <div>
    	<%
    	CountryService cser = new CountryService();
    	ArrayList<String> countryList = (ArrayList<String>)cser.getCountry();
    	%>
        <label for="msg">국가:</label>
   		<select name="country_eng">
    	<%for(int i=0; i<countryList.size(); i++) { %>
    	<% String[] divide = countryList.get(i).split(" "); %>
    	<% if(divide[1].equals(de.getCountry_eng())) { %>
	    <option  value="<%=countryList.get(i)%>" selected="selected"><%=countryList.get(i)%></option>
		<%} else {%>
		<option  value="<%=countryList.get(i)%>"><%=countryList.get(i)%>
		<%} %>
		<%} %>
		</select>
	</div>
    
    <br>
    <div>
        <label for="msg">특수관계자:</label>
        <%if(de.getSpecial_relation().equals("y")) { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="special_relation" checked="checked" />
        <label for="msg">n:</label>
        <input type="radio" value="n" name="special_relation"/>
        <%} else if(de.getSpecial_relation().equals("n")) { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="special_relation"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="special_relation" checked="checked" />
        <%} else { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="special_relation"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="special_relation"/>
        <%}%>
    </div>
    <div>
        <label for="msg">거래중지:</label>
         <%if(de.getTrade_stop().equals("y")) { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="trade_stop" checked="checked" />
        <label for="msg">n:</label>
        <input type="radio" value="n" name="trade_stop"/>
        <%} else if(de.getTrade_stop().equals("n")) { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="trade_stop"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="trade_stop" checked="checked" />
        <%} else { %>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="trade_stop"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="trade_stop"/>
        <%}%>
    </div>
    <div>
        <label for="msg">계약기간(시작):</label>
		<input type="date" id="start" name="contract_period_s"
       	value="<%=de.getContract_period_s()%>"
       	min="2000-01-01" max="2022-12-31"/>
    </div>
    <div>
        <label for="msg">계약기간(끝):</label>
        <input type="date" id="end" name="contract_period_e"
       	value="<%=de.getContract_period_e()%>"
       	min="2000-01-01" max="2022-12-31"/>
    </div>
    <div>
        <label for="msg">수정정보(수정인):</label>
        <input id="msg" name="regi_info_man"/>
    </div>
    <div class="button">
        <button type="submit">수정</button>
    </div>
    
     </form>
   
    	<a href="/addall">초기화</a>
    
    <div>
    	<form action="/accountupdate" method="post">
			    <label for="msg">busi_num_account:</label><br>
			    <input type="text" name="busi_num" value="<%=de.getBusi_num()%>" readonly="readonly" /><br>
			    <label for="msg">factory</label><br>
			    <input type="text" name="factory" value="<%=de.getFactory()%>" /><br>
			    <label for="msg">trade_bank:</label><br>
			    <input type="text" name="trade_bank" value="<%=de.getTrade_bank()%>"/><br>
			    <label for="msg">account_num:</label><br>
			    <input type="text" name="account_num" value="<%=de.getAccount_num()%>"/><br>
    			<button type="submit">수정</button>
    	</form>
    </div>
			    <a href="/delete?busi_num=<%=de.getBusi_num()%>">전체삭제</a>
</div>
    

<div>FOOTER</div>
</body>
</html>
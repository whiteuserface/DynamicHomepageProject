<%@page import="Service.CountryService"%>
<%@page import="Entity.BusiNum_Custom"%>
<%@page import="Service.CustomService"%>
<%@page import="Entity.Custom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js" ></script>
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
            <%
            
            %>
	</form>
	<label>전체목록</label>
		<%
		CustomService cs = new CustomService();
		ArrayList<BusiNum_Custom> AllBusi_num_Custom_list = cs.getAllBusi_num_Custom();
		//전체 목록을 줄꺼임. DAO 수정
		%>
			<%for (int i=0; i<AllBusi_num_Custom_list.size(); i++) { %>
				<div>
						<a href="/customdetail?busi_num=<%=AllBusi_num_Custom_list.get(i).getBusi_num()%>">
							<label for="msg">회사명:</label>
								<span><%=AllBusi_num_Custom_list.get(i).getBusi_num()%></span>
						</a>
				</div>
				<div>	<a href="/customdetail?busi_num=<%=AllBusi_num_Custom_list.get(i).getBusi_num()%>">
							<label for="msg">거래처명:</label>
								<span><%=AllBusi_num_Custom_list.get(i).getCustom()%></span>
						</a>
				<br>
				</div><br>
			<%} %>

<div>
	<form action="/custominsert" method="post">
    <div>
        <label for="msg">사업자번호:</label>
        <input type="text" name="busi_num" />
    </div>
    <div>
        <label for="msg">거래처명:</label>
        <input type="text" name="custom" />
    </div>
    <div>
        <label for="msg">약칭:</label>
        <input type="text" name="short_"/>
    </div>
    
    <div>
        <label for="msg">대표자:</label>
        <input type="text" name="ceo"/>
    </div>
    <div>
        <label for="msg">담당자:</label>
        <input type="text" name="charge_person"/>
    </div>
    <div>
        <label for="msg">업 태:</label>
        <input type="text" name="busi_condition"/>
    </div>
    <div>
        <label for="msg">종 목:</label>
        <input type="text" name="item"/>
    </div>
    
    <input type="hidden" id="confmKey" name="confmKey" value=""/>
		<table >
			<colgroup>
				<col style="width:20%"><col>
			</colgroup>
			<tbody>
				<tr>
					<th>우편번호</th>
					<td>
					    <input type="hidden" id="confmKey" name="" value=""  >
						<input type="text" id="zipNo" name="post_num" style="width:100px">
						<input type="button"  value="주소검색" onclick="goPopup();">
					</td>
				</tr>
				<tr>
					<th>도로명주소</th>
					<td><input type="text" id="roadAddrPart1" name="addr1" style="width:85% "></td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td>
						<input type="text" id="addrDetail" style="width:40%" value="상세주소" name="addr2">
						<input type="text" id="roadAddrPart2"  style="width:40%">
					</td>
				</tr>
			</tbody>
		</table>
    <div>
        <label for="msg">전화번호:</label>
        <input type="tel" name="tel"/>
    </div>
    <div>
        <label for="msg">팩스번호:</label>
        <input type="tel" name="fax"/>
    </div>
    <div>
        <label for="msg">홈페이지:</label>
        <input type="url" name="homepage"/>
    </div>
    <div>
        <label for="msg">법인여부:</label>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="co_yn"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="co_yn"/>
    </div>
    <div>
        <label for="msg">해외여부:</label>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="foreign_yn"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="foreign_yn"/>
    </div>
    <div>
        <label for="msg">과세구분:</label>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="tax_yn"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="tax_yn"/>
    </div>
    <div>
    	<%
    	CountryService cser = new CountryService();
    	ArrayList<String> countryList = cser.getCountry();
 
    	%>
        <label for="msg">국가:</label>
   		<select name="country_eng" value="<%%>%">
    	<%for(int i=0; i<countryList.size(); i++) { %>
	    <option value="<%=countryList.get(i)%>"><%=countryList.get(i)%></option>
		<%}%>
		</select>
		
		
	</div>
    <div>
    <br>
        
    </div>
    <div>
        <label for="msg">특수관계자:</label>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="special_relation"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="special_relation"/>
    </div>
    <div>
        <label for="msg">거래중지:</label>
        <label for="msg">y:</label>
        <input type="radio" value="y" name="trade_stop"/>
        <label for="msg">n:</label>
        <input type="radio" value="n" name="trade_stop"/>
    </div>
    <div>
        <label for="msg">계약기간(시작):</label>
		<input type="date" id="start" name="contract_period_s"
       	value="2000-01-01"
       	min="2000-01-01" max="2022-12-31"/>
    </div>
    <div>
        <label for="msg">계약기간(끝):</label>
        <input type="date" id="end" name="contract_period_e"
       	value="2000-01-01"
       	min="2000-01-01" max="2022-12-31"/>
    </div>
    <div>
        <label for="msg">등록정보(등록인):</label>
        <input id="msg" name="regi_info_man"/>
    </div>
    <div class="button">
        <button type="submit">등록</button>
    </div>
    </form>
    	<a href="/addall" >초기화</a>
    	
    	
    <div>
    	<form action="/insertaccount" method="post">
			    <label for="msg">busi_num_account:</label><br>
			    <input type="text" name="busi_num_account" /><br>
			    <label for="msg">factory</label><br>
			    <input type="text" name="factory" /><br>
			    <label for="msg">trade_bank:</label><br>
			    <input type="text" name="trade_bank" /><br>
			    <label for="msg">account_num:</label><br>
			    <input type="text" name="account_num" /><br>
			    <button type="submit">계좌등록</button>
    	</form>
    </div>
    

</div>
<div>FOOTER</div>
</body>
</html>
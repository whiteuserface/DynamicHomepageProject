package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountryDao {
	public ArrayList<String> getCountry(){
		ArrayList<String> insertlist = new ArrayList<>();
	    String insertSql = "select country_kor||' '||country_eng from country";
	    String inserturl = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(inserturl,"dlsdlworld","1234");
			PreparedStatement ps = con.prepareStatement(insertSql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				insertlist.add(rs.getString(1));
			}
			return insertlist;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertlist;
	}
}

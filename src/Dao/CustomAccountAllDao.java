package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.BusiNum_Custom;
import Entity.DetailEntity;

public class CustomAccountAllDao {
	public DetailEntity getAllDetail(String busi_num) {
		
		String sql = "select * from trim_all_view where trim(busi_num) = ?";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		DetailEntity de = null;	
		ResultSet rs =null;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,"dlsdlworld","1234");
			ps = con.prepareStatement(sql);
			ps.setString(1, busi_num);
			rs = ps.executeQuery();
		if(rs.next()){
			de = new DetailEntity(
					rs.getString(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getString(9),
					rs.getString(10),
					rs.getString(11),
					rs.getString(12),
					rs.getString(13),
					rs.getString(14),
					rs.getString(15),
					rs.getString(16),
					rs.getString(17),
					rs.getString(18),
					rs.getString(19),
					rs.getString(20),
					rs.getString(21),
					rs.getString(22),
					rs.getString(23),
					rs.getString(24),
					rs.getString(25),
					rs.getString(26),
					rs.getString(27),
					rs.getString(28),
					rs.getString(29)
					);
		}
		con.close();
		ps.close();
		rs.close();
		return de;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	
	return de;  
		
		
	}
}

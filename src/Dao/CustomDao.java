package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.net.WriteBuffer;

import Entity.BusiNum_Custom;
import Entity.Custom;

public class CustomDao {
	public void insertCustom(Custom custom) {
		
		String sql =
		"insert into custom (" + 
		"busi_num," + //1
		"custom," +  //2
		"short," +  //3
		"ceo," +  //4
		"charge_person," + //5 
		"busi_condition," +  //6
		"item," + //7
		"post_num," + //8 
		"addr1," + //9
		"addr2," + //10
		"tel," + //11
		"fax," + //12
		"homepage," + //13 
		"co_yn," + //14
		"foreign_yn," + //15 
		"tax_yn," +  //16
		"country_eng," + //17
		"country_kor," +  //18
		"special_relation," + //19
		"trade_stop," +  //20
		"contract_period_s," + //21 
		"contract_period_e," + //22
		"regi_info_man," + //23
		"regi_info_date" + //24
		") " + 
		"values" + 
		"(" + 
		"?," + //1
		"?," + //2
		"?," + //3
		"?," + //4
		"?," + //5
		"?," + //6
		"?," + //7
		"?," + //8
		"?," + //9
		"?," + //10
		"?," + //11
		"?," + //12
		"?," + //13
		"?," + //14
		"?," + //15
		"?," + //16
		"?," + //17
		"?," + //18
		"?," + //19
		"?," + //20
		"?," + //21
		"?," + //22
		"?," + //23
		"sysdate" + 
		")";
			
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, custom.getBusi_num());
			ps.setString(2, custom.getCustom());
			ps.setString(3, custom.getShort_());
			ps.setString(4, custom.getCeo());
			ps.setString(5, custom.getCharge_person());
			ps.setString(6, custom.getBusi_condition());
			ps.setString(7, custom.getItem());
			ps.setString(8, custom.getPost_num());
			ps.setString(9, custom.getAddr1());
			ps.setString(10, custom.getAddr2());
			ps.setString(11, custom.getTel());
			ps.setString(12, custom.getFax());
			ps.setString(13, custom.getHomepage());
			ps.setString(14, custom.getCo_yn());
			ps.setString(15, custom.getForeign_yn());
			ps.setString(16, custom.getTax_yn());
			ps.setString(17, custom.getCountry_eng());
			ps.setString(18, custom.getCountry_kor());
			ps.setString(19, custom.getspecial_relation());
			ps.setString(20, custom.gettrade_stop());
			ps.setString(21, String.valueOf(custom.getContract_period_s()));
			ps.setString(22, String.valueOf(custom.getContract_period_e()));
			ps.setString(23, custom.getRegi_info_man());
			
			ps.executeUpdate();
			
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Custom> getBusi_numSearchList(String busi_num) {
		List<Custom> list = new ArrayList<>();
		String sql = "select * from custom where trim(busi_num) like '%"+busi_num+"%'";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String custom = "";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
						Custom newcustom = new Custom(
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
						rs.getString(26)
						);
						list.add(newcustom);
			}
			if(list.size() != 0) {
				return list;
			}
			
			con.close();
			st.close();
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public void updateCustom(Custom custom, String busi_num) {
		String sql =
				"update custom set " +  
				"busi_num = ?," + //1
				"custom = ?," +  //2
				"short = ?," + //3
				"ceo = ?," + //4
				"charge_person = ?," + //5 
				"busi_condition = ?," +  //6
				"item = ?," +  //7
				"post_num = ?," + //8
				"addr1 = ?," + //9
				"addr2 = ?," + //10
				"tel = ?," + //11
				"fax = ?," + //12
				"homepage = ?," + //13
				"co_yn = ?," + //14
				"foreign_yn = ?," + //15 
				"tax_yn = ?," +  //16
				"country_eng = ?," +  //17
				"country_kor = ?," +  //18
				"special_relation = ?," +  //19
				"trade_stop = ?," + //20
				"contract_period_s = ?," + //21 
				"contract_period_e = ?," +  //22
				"modi_info_man = ?,"+ //23
				"modi_info_date = sysdate"+ 
				" " + 
				"where " + 
				"trim(busi_num) = ?"; //24
					
				
				String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				Connection con = null;
				PreparedStatement ps = null;
				String[] divideContainer = new String[3];
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection(url,"dlsdlworld","1234");
					ps = con.prepareStatement(sql);
					
					
			
					ps.setString(1, busi_num);
					ps.setString(2, custom.getCustom());
					ps.setString(3, custom.getShort_());
					ps.setString(4, custom.getCeo());
					ps.setString(5, custom.getCharge_person());
					ps.setString(6, custom.getBusi_condition());//6
					ps.setString(7, custom.getItem());//7
					ps.setString(8, custom.getPost_num());
					ps.setString(9, custom.getAddr1());
					ps.setString(10, custom.getAddr2());
					ps.setString(11, custom.getTel());
					ps.setString(12, custom.getFax());
					ps.setString(13, custom.getHomepage());
					ps.setString(14, custom.getCo_yn());
					ps.setString(15, custom.getForeign_yn());
					ps.setString(16, custom.getTax_yn());
					ps.setString(17, custom.getCountry_eng());
					ps.setString(18, custom.getCountry_kor());
					ps.setString(19, custom.getspecial_relation());
					ps.setString(20, custom.gettrade_stop());
					ps.setString(21, custom.getContract_period_s());
					ps.setString(22, custom.getContract_period_e());
					ps.setString(23, custom.getModi_info_man());
					ps.setString(24, busi_num);
					
					
					ps.executeUpdate();
					
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						ps.close();
						con.close();
					} catch(Exception e) {
						e.printStackTrace();
					}
					
				}
		
	}

	public List<Custom> getCustomSearchList(String customName) {
		List<Custom> list = new ArrayList<>();
		String sql = "select * from custom where custom like '%"+customName+"%'";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String custom = "";
		Custom newcustom = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
			Statement ps = con.createStatement();
			
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				newcustom = new Custom(
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
						rs.getString(26)
						);
				list.add(newcustom);
			}
			
			con.close();
			ps.close();
			rs.close();
			
			if(list.size() != 0) {
				return list;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delete(String busi_num) {
		String sql = "delete from custom where trim(busi_num)=?";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String custom = "";
		Custom newcustom = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, busi_num);
			ps.executeUpdate();
			
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
			
		
	}
	
	public ArrayList<BusiNum_Custom> getAllBusi_num_Custom() {
		ArrayList<BusiNum_Custom> list = new ArrayList<>();
		String sql = "select trim(busi_num) busi_num ,custom from custom";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		BusiNum_Custom bc; 		
		ResultSet rs =null;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,"dlsdlworld","1234");
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		while(rs.next()){
			bc = new BusiNum_Custom(rs.getString(1),rs.getString(2));
			list.add(bc);
		}
		con.close();
		ps.close();
		rs.close();
		return list;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	
	return list;  

	}

	public Custom getBusi_numCustom(String busi_num) {
		String sql = "select * from custom where trim(busi_num)=?";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		Custom newcustom = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"dlsdlworld","1234");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, busi_num);
			
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next()) {
				newcustom = new Custom(
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
						String.valueOf(rs.getDate(21)),
						String.valueOf(rs.getDate(22)),
						rs.getString(23),
						String.valueOf(rs.getDate(24)),
						rs.getString(25),
						String.valueOf(rs.getDate(26))
						);
				
			}
			
			con.close();
			ps.close();
			rs.close();
			if(newcustom != null) {
				return newcustom;				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newcustom;
	}
	
	

	

	
	
	
}

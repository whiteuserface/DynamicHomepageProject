package Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.net.WriteBuffer;

import Dao.CustomDao;
import Entity.BusiNum_Custom;
import Entity.Custom;

public class CustomService {
	CustomDao cd = new CustomDao();
	public void insert(Custom custom) {
		cd.insertCustom(custom);
	}
	
	public List<Custom> getBusi_numSearchList(String busi_num) {
		List<Custom> list = new ArrayList<>();
		list = cd.getBusi_numSearchList(busi_num);
		return list;
	}
	
	public List<Custom> getCustomSearchList(String custom) {
		List<Custom> list = new ArrayList<>();
		list = cd.getCustomSearchList(custom);
		return list;
	}
	
	public void updateCustom(Custom custom, String busi_num) {
		cd.updateCustom(custom, busi_num);
	}
	
	public void deleteCustom(String busi_num) {
		cd.delete(busi_num);
	}
	
	public ArrayList<BusiNum_Custom> getAllBusi_num_Custom() {
		ArrayList<BusiNum_Custom> tmp = cd.getAllBusi_num_Custom();
		return tmp;
	}
	
	public Custom getBusi_numCustom(String busi_num) {
		Custom tmp = cd.getBusi_numCustom(busi_num);
		return tmp;
	}
}

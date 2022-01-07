package Service;

import Dao.CustomAccountAllDao;
import Entity.DetailEntity;

public class DetailService {
	CustomAccountAllDao caad = new CustomAccountAllDao();
	public DetailEntity getDetailEntity(String busi_num) {
		DetailEntity tmp = caad.getAllDetail(busi_num);
		return tmp;
	}
}

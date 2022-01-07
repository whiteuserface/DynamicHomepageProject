package Service;

import java.util.ArrayList;

import Dao.CountryDao;

public class CountryService {
	public ArrayList<String> getCountry(){
		CountryDao cd = new CountryDao();
		return cd.getCountry();
	}
}

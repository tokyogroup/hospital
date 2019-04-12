package com.azeroth.daoimpl;

import java.util.List;

import com.azeroth.dao.RegistrationDao;
import com.azeroth.utils.DBHelper;

public class RegistrationDaoImpl implements RegistrationDao {

	
	public List<RegistrationDao> queryRigistration() {
		DBHelper.getConn();
		
	
		return null;
	}

	
	public boolean addRegistration(RegistrationDao registration) {
		
		return false;
	}

	
	public boolean updateRegistration(String rg_id) {
		
		return false;
	}

	
	public boolean delRegistration(String rg_id) {
		
		return false;
	}

}

package com.azeroth.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.azeroth.bean.Registration;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.RegistrationDao;
import com.azeroth.utils.DBHelper;

public class RegistrationDaoImpl implements RegistrationDao {

	
	public List<Registration> queryRigistration(String condition) {
		condition =null;
		DBHelper.getConn();
		String sql="select * from T_registration where 1=1"+ condition;
		Object[]obj= {};
		List<Registration> registList = new ArrayList<Registration>();
		ResultSet rs=DBHelper.getRs(sql, obj);
		try {
			while(rs.next()) {
				//registr表字段rg_id pi_id u_id u_id2 rg_price rg_date  rg_status
				String rg_id = rs.getString("rg_id");
				String pi_id = rs.getString("pi_id");
				String u_id = rs.getString("u_id");
				String u_id2 = rs.getString("u_id2");
				double rg_price = rs.getDouble("rg_price");
				String rg_date = rs.getString("rg_date");
				int rg_status = rs.getInt("rg_status");
				Userinfos userinfos= new Userinfos();
				Registration registration = new Registration(rg_id, pi_id, u_id2, userinfos, rg_price, rg_date, rg_status);
			}
			   return registList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	
	public boolean addRegistration(Registration registration) {
		
		String sql= "insert into T_registration values(?,?,?,?,?,?,?)";
		Object[] obj= {registration.getRg_id(),registration.getPi_id(),registration.getU_id(),registration.getUserinfos().getU_id(),registration.getRg_price(),registration.getRg_date(),registration.getRg_status()};
		DBHelper.runSql(sql, obj);
		return true;
	}

	
	public boolean updateRegistration(String rg_id) {
		
		return false;
	}

	
	public boolean delRegistration(String rg_id) {
		String sql="delete from t_registration where rg_id=?";
		Object[]obj ={rg_id};
	    DBHelper.runSql(sql, obj);
		
		return true;
	}

}

package com.azeroth.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.azeroth.bean.Patients;
import com.azeroth.bean.Registration;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.PatientsDao;
import com.azeroth.dao.RegistrationDao;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.utils.DBHelper;

public class RegistrationDaoImpl implements RegistrationDao {

	
	public List<Registration> queryRigistration(String condition) {
		UserinfosDao userinfosDaoimpl = new UserinfosDaoimpl();
		PatientsDao patientsDaoimpl = new PatientsDaoimpl();
		DBHelper.getConn();
		String sql="select * from T_registration r,t_patients p where 1=1 and r.pi_id=p.pi_id "+ condition;
		System.out.println("----sql语句---"+sql);
		Object[]obj= {};
		List<Registration> registList = new ArrayList<Registration>();
		ResultSet rs=DBHelper.getRs(sql, obj);
		try {
			while(rs.next()) {
				//registr表字段rg_id pi_id u_id u_id2 rg_price rg_date  rg_status
				String rg_id = rs.getString("rg_id");
				String pi_id = rs.getString("pi_id");
				Patients patients = patientsDaoimpl.findById(pi_id);
				String u_id = rs.getString("u_id");
				String u_id2 = rs.getString("u_id2");
				double rg_price = rs.getDouble("rg_price");
				String rg_date = rs.getString("rg_date");
				int rg_status = rs.getInt("rg_status");
				Userinfos userinfos= userinfosDaoimpl.userFindByUid(u_id2);
				Registration registration = new Registration(rg_id, patients, u_id2, userinfos, rg_price, rg_date, rg_status);
				registList.add(registration);
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
		Object[] obj= {registration.getRg_id(),registration.getPatients().getPi_id(),registration.getU_id(),registration.getUserinfos().getU_id(),registration.getRg_price(),registration.getRg_date(),registration.getRg_status()};
		DBHelper.runSql(sql, obj);
		return true;
	}

	
	public boolean updateRegistration(String rg_id) {
		
		return false;
	}

	
	public boolean delRegistration(String rg_id) {
		String sql="delete from t_registration where rg_id=?";
		Object[]obj ={rg_id};
	    boolean flag =DBHelper.runSql(sql, obj);
		if(flag) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		return true;
	}


	@Override
	public boolean updateStatusRegistration(String rg_id) {

		String sql="update t_registration set rg_status=1 where rg_id=?";
		Object[]obj ={rg_id};
	    boolean flag =DBHelper.runSql(sql, obj);
		if(flag) {
			System.out.println("更改状态成功");
		}else {
			System.out.println("更改状态失败");
		}
		return true;
	
	}

}

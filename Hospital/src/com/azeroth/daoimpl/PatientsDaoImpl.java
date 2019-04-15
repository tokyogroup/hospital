package com.azeroth.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.azeroth.bean.Patients;
import com.azeroth.dao.PatientsDao;
import com.azeroth.utils.DBHelper;

public class PatientsDaoImpl implements PatientsDao {

//pi_id pi_name pi_sex pi_age pi_date pi_tele pi_addr
	@Override
	public boolean addPatients(Patients patients) {
		String sql="insert into t_patients values(?,?,?,?,Str_to_date(?,'%Y-%m-%d'),?,?)";
		Object[] obj= {patients.getPi_id(),patients.getPi_name(),patients.getPi_sex(),patients.getPi_age(),patients.getPi_date(),patients.getPi_tele(),patients.getPi_addr()};
		DBHelper.common(sql, obj);
		return true;
	}

	@Override
	public Patients queryPatientsbyid(String pi_id) {
		String sql="select * from t_patients where pi_id=?";
		Object[]obj = {pi_id};
		ResultSet rs=DBHelper.getResultSet(sql, obj);
		try {
			if(rs.next()) {
				String pi_name= rs.getString("pi_name");
				String pi_sex=rs.getString("pi_sex");
				int pi_age=rs.getInt("pi_age");
				String pi_date=rs.getString("pi_date");
				String pi_tele=rs.getString("pi_tele");
				String pi_addr=rs.getString("pi_addr");
				Patients patients =new Patients(pi_id, pi_name, pi_sex, pi_age, pi_date, pi_tele, pi_addr);
				return patients;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}

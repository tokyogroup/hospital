package com.azeroth.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azeroth.bean.Case1;
import com.azeroth.bean.Patients;
import com.azeroth.bean.Section;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.Case1Dao;
import com.azeroth.dao.PatientsDao;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.utils.DBHelper;

public class Case1Daoimpl implements Case1Dao {

	@Override
	public List<Case1> case1FindAll() {
		try {
			
			String sql = "select * from t_case";
			Object[] obj = {};
			ResultSet rs = DBHelper.getRs(sql, obj);
			List<Case1> case1List = new ArrayList<Case1>();
			while(rs.next()) {
				String c_id = rs.getString("c_id");
				String pi_id = rs.getString("pi_id");
				String u_id = rs.getString("u_id");
				String c_date = rs.getString("c_date");
				String c_result = rs.getString("c_result");
				String c_method = rs.getString("c_method");
				int c_status = rs.getInt("c_status");
				Case1 case1 = new Case1();
				case1.setC_date(c_date);
				case1.setC_id(c_id);
				Patients patients = new Patients();
				patients.setPi_id(pi_id);
				case1.setPatients(patients);
				Userinfos userinfos = new Userinfos();
				userinfos.setU_id(u_id);
				case1.setUserinfos(userinfos);
				case1.setC_result(c_result);
				case1.setC_method(c_method);
				case1.setC_status(c_status);
				
				case1List.add(case1);	
			}
			return case1List;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Case1> case1FindByPiId(String pi_id) {
		PatientsDao patientsDao = new PatientsDaoimpl();
		
		try {
			
			String sql = "select * from t_case where pi_id=? order by c_date desc";
			Object[] obj = {pi_id};
			ResultSet rs = DBHelper.getRs(sql, obj);
			List<Case1> case1List = new ArrayList<Case1>();
			while(rs.next()) {
				String c_id = rs.getString("c_id");
				String u_id = rs.getString("u_id");
				String c_date = rs.getString("c_date");
				String c_result = rs.getString("c_result");
				String c_method = rs.getString("c_method");
				int c_status = rs.getInt("c_status");
				Case1 case1 = new Case1();
				case1.setC_date(c_date);
				case1.setC_id(c_id);
				Patients patients = patientsDao.findById(pi_id);
				case1.setPatients(patients);
				Userinfos userinfos = new Userinfos();
				userinfos.setU_id(u_id);
				case1.setUserinfos(userinfos);
				case1.setC_result(c_result);
				case1.setC_method(c_method);
				case1.setC_status(c_status);	
				case1List.add(case1);	
			}
			return case1List;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void case1Add(Case1 case1) {

		try {
			String sql = "insert into t_case values(?,?,?,?,?,?,?)";			
			Object[] obj = {case1.getC_id(),case1.getPatients().getPi_id(),case1.getUserinfos().getU_id(),case1.getC_date(),case1.getC_result(),case1.getC_method(),case1.getC_status()};
			boolean rs =DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("病例添加成功");
		
			}else {
				System.out.println("病例添加失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		
	}

	@Override
	public void case1Update(Case1 case1) {

		try {
			String sql = "update t_case set pi_id=?,u_id=?,c_date=?,c_result=?,c_method=?,c_status=? where c_id=?";			
			Object[] obj = {case1.getPatients().getPi_id(),case1.getUserinfos().getU_id(),case1.getC_date(),case1.getC_result(),case1.getC_method(),case1.getC_status(),case1.getC_id()};
			boolean rs =DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("病例修改成功");
		
			}else {
				System.out.println("病例修改失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		
	}

	@Override
	public Case1 case1FindByCid(String c_id) {
		try {
			PatientsDao patientsDao = new PatientsDaoimpl();
			UserinfosDao userinfosDao = new UserinfosDaoimpl();
			String sql = "select * from t_case where c_id=?";
			Object[] obj = {c_id};
			ResultSet rs = DBHelper.getRs(sql, obj);
	
			while(rs.next()) {
				
				String pi_id = rs.getString("pi_id");
				String u_id = rs.getString("u_id");
				String c_date = rs.getString("c_date");
				String c_result = rs.getString("c_result");
				String c_method = rs.getString("c_method");
				int c_status = rs.getInt("c_status");
				Case1 case1 = new Case1();
				case1.setC_date(c_date);
				case1.setC_id(c_id);
				Patients patients = patientsDao.findById(pi_id);
				case1.setPatients(patients);
				Userinfos userinfos = userinfosDao.userFindByUid(u_id);
				
				case1.setUserinfos(userinfos);
				case1.setC_result(c_result);
				case1.setC_method(c_method);
				case1.setC_status(c_status);		
				return case1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

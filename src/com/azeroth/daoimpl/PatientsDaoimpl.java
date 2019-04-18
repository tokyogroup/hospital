package com.azeroth.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.azeroth.bean.Patients;
import com.azeroth.bean.Registration;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.PatientsDao;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.utils.DBHelper;
import com.azeroth.utils.UUIDUtil;

public class PatientsDaoimpl implements PatientsDao{
	//增加病人信息
	public void  addPatient(Patients pa) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		String sql = "insert into t_patients values (?,?,?,?,?,?,?)";
		
		try {
			//执行sql语句
			ps = conn.prepareStatement(sql);
			//生成短uuid
			UUIDUtil uuid = new UUIDUtil();
			String id=uuid.getId();
			ps.setString(1, "PA"+id);
			ps.setString(2, pa.getPi_name());
			ps.setString(3, pa.getPi_sex());
			ps.setInt(4, pa.getPi_age());
			ps.setString(5, pa.getPi_date());
			ps.setString(6, pa.getPi_tele());
			ps.setString(7, pa.getPi_addr());
			
			int num = ps.executeUpdate();
			if(num>0) {
				System.out.println("添加成功！");
				
			}else {
				System.out.println("添加失败！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConn(conn, ps, null);
		}
		
	}

	//根据姓名来删除
	public boolean  delPatient(String pi_id) {
		//1、定义两个接口
				Connection conn = null;
				//Statement sm = null;
				PreparedStatement ps = null;
				String sql = "delete from t_patients where pi_id = ?";
				//2、实例化两个接口
				try {
					conn = DBHelper.getConn();
					//3、执行sql语句
					ps = conn.prepareStatement(sql);
					ps.setString(1, pi_id);
					int num = ps.executeUpdate();
					if(num>0) {
						System.out.println("删除成功！");
						return true;
					}else {
						System.out.println("删除失败！");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
	}

	//根据id来更改病人的性别及年龄
	public void  modPatient(String pi_tele,String pi_addr,String pi_id) {
		//1、定义两个接口
				Connection conn = null;
				PreparedStatement ps = null;
                Patients patients = findById(pi_id);
				//2、实例化两个接口
				try {
					conn = DBHelper.getConn();
					//执行sql语句
					ps = conn.prepareStatement("update t_patients set pi_tele=?,pi_addr=? where pi_id=?");
					ps.setString(1, pi_tele);
					ps.setString(2, pi_addr);
					ps.setString(3, pi_id);
					int num = ps.executeUpdate();
					if(num>0) {
						System.out.println("修改成功！");
						
					}else {
						System.out.println("修改失败！");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}
	
	//查询全部病人信息
	public List<Patients> findAll() {
		List<Patients> pList = new ArrayList<Patients>();
		String sql = "select * from t_patients";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBHelper.getConn();
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String pi_id=rs.getString("pi_id");
				String pi_name=rs.getString("pi_name");
				String pi_sex=rs.getString("pi_sex");
				int pi_age=rs.getInt("pi_age");
				String pi_date= rs.getString("pi_date");
				String pi_tele = rs.getString("pi_date");
				String pi_addr = rs.getString("pi_addr");
				Patients patients = new Patients(pi_id, pi_name, pi_sex, pi_age, pi_date, pi_tele, pi_addr);
				pList.add(patients);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConn(conn, ps, rs);
		}
		
		return pList;
	}

	//根据名字模糊查询
	public List<Patients> findByName(String name) {
		List<Patients> pList = new ArrayList<Patients>();
		String sql = "select * from t_patients where pi_name like ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConn();
			ps = conn.prepareStatement(sql);
			//向问号传递"%"+name+"%"
			ps.setString(1, "%"+name+"%");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String pi_id=rs.getString("pi_id");
				String pi_name=rs.getString("pi_name");
				String pi_sex=rs.getString("pi_sex");
				int pi_age=rs.getInt("pi_age");
				String pi_date= rs.getString("pi_date");
				String pi_tele = rs.getString("pi_date");
				String pi_addr = rs.getString("pi_addr");
				Patients patients = new Patients(pi_id, pi_name, pi_sex, pi_age, pi_date, pi_tele, pi_addr);
				pList.add(patients);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConn(conn, ps, rs);
		}
		return pList;
	}

	//根据卡号查询
	public Patients findById(String pi_id) {
		String sql = "select * from t_patients where pi_id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		conn = DBHelper.getConn();
		ps = conn.prepareStatement(sql);
		//向问号传传值
		ps.setString(1, pi_id);
		rs=ps.executeQuery();
		
		if(rs.next()) {
			String pid=rs.getString("pi_id");
			String pi_name=rs.getString("pi_name");
			String pi_sex=rs.getString("pi_sex");
			int pi_age=rs.getInt("pi_age");
			String pi_date= rs.getString("pi_date");
			String pi_tele = rs.getString("pi_date");
			String pi_addr = rs.getString("pi_addr");
			Patients patients =new Patients(pi_id, pi_name, pi_sex, pi_age, pi_date, pi_tele, pi_addr);
			return patients;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBHelper.closeConn(conn, ps, rs);
	}
		return null;
	}

	@Override
	public List<Patients> queryPatients(String condition) {
		DBHelper.getConn();
		String sql="select * from t_patients where 1=1 "+ condition;
		System.out.println("----sql语句---"+sql);
		Object[]obj= {};
		List<Patients> patientsList = new ArrayList<Patients>();
		ResultSet rs=DBHelper.getRs(sql, obj);
		try {
			while(rs.next()) {
				String pi_id= rs.getString("pi_id");
				String pi_name=rs.getString("pi_name");
				String pi_sex=rs.getString("pi_sex");
				int pi_age=rs.getInt("pi_age");
				String pi_date=rs.getString("pi_date");
				String pi_tele=rs.getString("pi_tele");
				String pi_addr=rs.getString("pi_addr");
                Patients patients = new Patients(pi_id, pi_name, pi_sex, pi_age, pi_date, pi_tele, pi_addr);
				patientsList.add(patients);
			}
			   return patientsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	

}
package com.azeroth.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.azeroth.bean.Patients;
import com.azeroth.dao.PatientsDao;
import com.azeroth.util.DBUtil;

public class PatientsDaoImpl implements PatientsDao{
	//增加病人信息
	public void  addPatient(Patients pa) {
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		String sql = "insert into t_patients(pi_id,pi_name,pi_sex,pi_age) values (?,?,?,?)";
		
		try {
			//执行sql语句
			ps = conn.prepareStatement(sql);
			//生成唯一编号
			ps.setString(1, UUID.randomUUID().toString());
			ps.setString(2, pa.getPi_name());
			ps.setString(3, pa.getPi_sex());
			ps.setInt(4, pa.getPi_age());
			int num = ps.executeUpdate();
			if(num>0) {
				System.out.println("添加成功！");
				
			}else {
				System.out.println("添加失败！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.getClose(conn, ps, null);
		}
		
	}

	//根据姓名来删除
	public void  delPatient(String name) {
		//1、定义两个接口
				Connection conn = null;
				//Statement sm = null;
				PreparedStatement ps = null;
				String sql = "delete from t_patients where pi_name = ?";
				//2、实例化两个接口
				try {
					conn = DBUtil.getConn();
					//3、执行sql语句
					ps = conn.prepareStatement(sql);
					ps.setString(1, name);
					int num = ps.executeUpdate();
					if(num>0) {
						System.out.println("删除成功！");
						
					}else {
						System.out.println("删除失败！");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	//根据姓名来更改病人的性别及年龄
	public void  modPatient(Patients pa) {
		//1、定义两个接口
				Connection conn = null;
				PreparedStatement ps = null;

				//2、实例化两个接口
				try {
					conn = DBUtil.getConn();
					//执行sql语句
					ps = conn.prepareStatement("update t_patients set pi_sex = ?,pi_age = ? where pi_name = ?");
					ps.setString(1, pa.getPi_sex());
					ps.setInt(2, pa.getPi_age());
					ps.setString(3, pa.getPi_name());
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
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String pi_id=rs.getString("pi_id");
				String pi_name=rs.getString("pi_name");
				String pi_sex=rs.getString("pi_sex");
				int pi_age=rs.getInt("pi_age");
				Patients patients = new Patients(pi_id, pi_name, pi_sex, pi_age);
				pList.add(patients);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.getClose(conn, ps, rs);
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
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			//向问号传递"%"+name+"%"
			ps.setString(1, "%"+name+"%");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String pid=rs.getString("pi_id");
				String pname=rs.getString("pi_name");
				String psex=rs.getString("pi_sex");
				int page=rs.getInt("pi_age");
				Patients patients = new Patients(pid,pname,psex,page);
				pList.add(patients);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.getClose(conn, ps, rs);
		}
		return pList;
	}

}

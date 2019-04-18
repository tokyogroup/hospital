package com.azeroth.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.azeroth.bean.Medicine;
import com.azeroth.dao.MedicineDao;
import com.azeroth.utils.DBHelper;


public  class MedicineDaoimpl implements MedicineDao{
	//增加药品信息
	public void addMedicine(Medicine me) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps=null;
		String sql = "insert into t_medicine (m_id,m_name,m_spec,m_price,m_function,m_addr,m_count) values(?,?,?,?,?,?,?)";
		try {
			//执行sql语句
			ps=conn.prepareStatement(sql);
			ps.setString(1, me.getM_id());
			ps.setString(2, me.getM_name());
			ps.setString(3, me.getM_spec());
			ps.setDouble(4, me.getM_price());
			ps.setString(5, me.getM_function());
			ps.setString(6, me.getM_addr());
			ps.setInt(7, me.getM_count());
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
	//删除药品信息
	public void delMedicine(String m_id) {
		//1、定义两个接口
		Connection conn = null;
		//Statement sm = null;
		PreparedStatement ps = null;
		String sql = "delete from t_medicine where m_id = ?";
		//2、实例化两个接口
		try {
			conn = DBHelper.getConn();
			//3、执行sql语句
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_id);
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
	//修改药品信息
	public void modMedicine(Medicine me) {
		//1、定义两个接口
		Connection conn = null;
		PreparedStatement ps = null;

		//2、实例化两个接口
		try {
			conn = DBHelper.getConn();
			//执行sql语句
			//m_id,m_name,m_spec,m_price,m_function,m_addr,m_count
			ps = conn.prepareStatement("update t_medicine set m_spec = ?,m_price = ?,m_function=?,m_addr=?,m_count=?,m_name =? where m_id=?");
			ps.setString(1, me.getM_spec());
			ps.setDouble(2, me.getM_price());
			ps.setString(3, me.getM_function());
			ps.setString(4, me.getM_addr());
			ps.setInt(5, me.getM_count());
			ps.setString(6, me.getM_name());
			ps.setString(7, me.getM_id());
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
	//查询药品信息列表
	public List<Medicine> findAll() {
		List<Medicine> mList = new ArrayList<Medicine>();
		String sql = "select * from t_medicine";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBHelper.getConn();
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				//m_id,m_name,m_spec,(double)m_price,m_function,m_addr,m_count
				String m_id=rs.getString("m_id");
				String m_name=rs.getString("m_name");
				String m_spec=rs.getString("m_spec");
				double m_price=rs.getInt("m_price");
				String m_function=rs.getString("m_function");
				String m_addr=rs.getString("m_addr");
				int m_count=rs.getInt("m_count");
				Medicine med = new Medicine(m_id, m_name, m_spec, m_price, m_function, m_addr, m_count);
				mList.add(med);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConn(conn, ps, rs);
		}
		//返回药品信息列表
		return mList;
	}
	//根据药品名称查询
	public List<Medicine> findAll(String name) {
		List<Medicine> mList = new ArrayList<Medicine>();
		String sql = "select * from t_medicine where m_name like ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBHelper.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				//m_id,m_name,m_spec,(double)m_price,m_function,m_addr,m_count
				String m_id=rs.getString("m_id");
				String m_name=rs.getString("m_name");
				String m_spec=rs.getString("m_spec");
				double m_price=rs.getInt("m_price");
				String m_function=rs.getString("m_function");
				String m_addr=rs.getString("m_addr");
				int m_count=rs.getInt("m_count");
				Medicine med = new Medicine(m_id, m_name, m_spec, m_price, m_function, m_addr, m_count);
				mList.add(med);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConn(conn, ps, rs);
		}
		//返回结果
		return mList;
	}
	@Override
	public Medicine findbyMid(String m_id) {
		String sql = "select * from t_medicine where m_id=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBHelper.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, m_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				//m_id,m_name,m_spec,(double)m_price,m_function,m_addr,m_count
				
				String m_name=rs.getString("m_name");
				String m_spec=rs.getString("m_spec");
				double m_price=rs.getInt("m_price");
				String m_function=rs.getString("m_function");
				String m_addr=rs.getString("m_addr");
				int m_count=rs.getInt("m_count");
				Medicine med = new Medicine(m_id, m_name, m_spec, m_price, m_function, m_addr, m_count);
				return med;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConn(conn, ps, rs);
		}
		//返回结果
		return null;
	}
	@Override
	public void updateCount(String m_id, int rc_count) {

		String sql = "update t_medicine m set m_count=m.m_count-? where m_id=?";
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DBHelper.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rc_count);
			ps.setString(2, m_id);
			int num = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConn(conn, ps, null);
		}
		//返回结果
	
	
		
	}
	@Override
	public List<Medicine> find(String condition) {

		List<Medicine> mList = new ArrayList<Medicine>();
		String sql = "select * from t_medicine where 1=1 "+condition;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBHelper.getConn();
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				//m_id,m_name,m_spec,(double)m_price,m_function,m_addr,m_count
				String m_id=rs.getString("m_id");
				String m_name=rs.getString("m_name");
				String m_spec=rs.getString("m_spec");
				double m_price=rs.getInt("m_price");
				String m_function=rs.getString("m_function");
				String m_addr=rs.getString("m_addr");
				int m_count=rs.getInt("m_count");
				Medicine med = new Medicine(m_id, m_name, m_spec, m_price, m_function, m_addr, m_count);
				mList.add(med);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConn(conn, ps, rs);
		}
		//返回结果
		return mList;
	
	}
}

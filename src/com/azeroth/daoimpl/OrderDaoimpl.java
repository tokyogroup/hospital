package com.azeroth.daoimpl;

import java.sql.ResultSet;

import com.azeroth.bean.Case1;
import com.azeroth.bean.Order;
import com.azeroth.dao.Case1Dao;
import com.azeroth.dao.OrderDao;
import com.azeroth.utils.DBHelper;

public class OrderDaoimpl implements OrderDao {

	@Override
	public void orderAdd(Order order) {
		try {
			String sql = "insert into t_order values(?,?,?,?)";
			Object[] obj = {order.getO_id(),order.getCase1().getC_id(),order.getTotal(),order.getO_status()}; 
			boolean rs = DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("订单添加成功");
			}else {
				System.out.println("订单添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Order oerderFind(String o_id) {
		try {
			String sql = "select * from t_order where o_id=?";
			Object[] obj = {o_id}; 
			ResultSet rs = DBHelper.getRs(sql, obj);
			Case1Dao case1Dao = new Case1Daoimpl();
			while(rs.next()) {
				String c_id = rs.getString("c_id");
				Case1 case1 = case1Dao.case1FindByCid(c_id);
				double o_total = rs.getDouble("o_total");
				int o_status = rs.getInt("o_status");
				Order order = new Order(o_id,o_total,o_status,case1);
				return order;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return null;
	}

	@Override
	public void orderUpdate(Order order) {

		try {
			String sql = "update t_order o set o.o_total=o.o_total+? where o.c_id=?";
			Object[] obj = {order.getTotal(),order.getCase1().getC_id()}; 
			boolean rs = DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("订单修改总价成功");
			}else {
				System.out.println("订单修改总价失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		
	}

	@Override
	public void orderCut(Order order) {


		try {
			String sql = "update t_order o set o.o_total=o.o_total-? where o.c_id=?";
			Object[] obj = {order.getTotal(),order.getCase1().getC_id()}; 
			boolean rs = DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("订单修改总价成功");
			}else {
				System.out.println("订单修改总价失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateStatus(String o_id) {



		try {
			String sql = "update t_order o set o.o_status=1 where o.o_id=?";
			Object[] obj = {o_id}; 
			boolean rs = DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("订单修改状态成功");
			}else {
				System.out.println("订单修改状态失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}

}

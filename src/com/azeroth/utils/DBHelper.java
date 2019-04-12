package com.azeroth.utils;

import java.sql.*;

public class DBHelper {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String UIL = "jdbc:mysql://localhost:3306/hospital?characterEncoding=utf-8";
	static final String USER = "root";
	static final String PASS = "123456";
	public static Connection getConn() {
		Connection cn = null;
		try {
			Class.forName(JDBC_DRIVER);
			cn =DriverManager.getConnection(UIL,USER,PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	public static void closeConn(Connection cn,Statement sm,ResultSet rs) {
		try {
			if(cn !=null)cn.close();
			if(sm !=null)sm.close();
			if(rs !=null)rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet getRs (String sql,Object...obj) {
		Connection cn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn=getConn();
			ps=cn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			rs=ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

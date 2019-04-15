package com.azeroth.utils;

import java.sql.*;


public class DBHelper {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/hospital?serverTimezone=UTC&characterEncoding=utf-8";
	static final String USER = "root";
	static final String PASS = "123456";
	//1、连接方法
			public static Connection getConn() {
				try {
					//1-1、注册驱动
					Class.forName(JDBC_DRIVER);
					//1-2、获取连接对象
					Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
					System.out.println("connection:"+connection);
					return connection;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			
			//2、关闭方法
			public static void getClose(Connection conn,Statement sm,ResultSet rs ) {
				try {
					if(conn!=null)conn.close();
					if(sm!=null)sm.close();
					if(rs!=null) rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			/**
			 * 通用的增删改操作
			 * @param sql   动态的sql语句
			 * @param obj	？号对应的值
			 * 
			 * delete from dept where deptno=?
			 * insert into dept values(?,?,?)
			 */
			public static boolean common(String sql,Object...obj) {
				Connection conn = null;
				PreparedStatement ps = null;
				
				try {
					conn = DBHelper.getConn();
					ps = conn.prepareStatement(sql);
					//处理问号传值
					for (int i = 0; i < obj.length; i++) {
						ps.setObject(i+1, obj[i]);//1
					}
					int num = ps.executeUpdate();
					if(num>0) {
						System.out.println("操作成功！！！");
						return true;
					}else {
						System.out.println("操作失败！！！");
						return false;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			
			//封装通过的查询功能
			public static ResultSet  getResultSet(String sql,Object...obj) {
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try {
					conn = DBHelper.getConn();
					ps = conn.prepareStatement(sql);
					//处理问号传值
					for (int i = 0; i < obj.length; i++) {
						ps.setObject(i+1, obj[i]);
					}
					rs = ps.executeQuery();
					return rs;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
}

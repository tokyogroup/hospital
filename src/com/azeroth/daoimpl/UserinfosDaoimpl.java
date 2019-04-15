package com.azeroth.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azeroth.bean.Section;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.utils.DBHelper;


public class UserinfosDaoimpl implements UserinfosDao {

	@Override
	public boolean userAdd(Userinfos userinfos) {

		try {
			String sql = "insert into t_userinfos values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			Object[] obj = {userinfos.getU_id(),userinfos.getS_id(),userinfos.getPr_id(),userinfos.getU_pwd(),userinfos.getU_name(),userinfos.getU_title(),userinfos.getU_age(),userinfos.getU_sex(),userinfos.getU_tel(),userinfos.getU_taskstate(),userinfos.getU_email(),userinfos.getU_exp()};
			boolean rs =DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("用户添加成功");
				return true;
			}else {
				System.out.println("用户添加失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
		
	}

	@Override
	public boolean userDelete(String u_id) {

		try {
			String sql = "delete from t_userinfos where u_id=?";
			
			Object[] obj = {u_id};
			boolean rs =DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("用户删除成功");
				return true;
			}else {
				System.out.println("用户删除失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
		
	}

	@Override
	public boolean userUpdate(Userinfos userinfos) {

		try {
			String sql = "update t_userinfos set s_id=?,pr_id=?,u_pwd=?,u_name=?,u_title=?,u_age=?,u_sex=?,u_tel=?,u_taskstate=?,u_email=?,u_exp=? where u_id=?";
			
			Object[] obj = {userinfos.getS_id(),userinfos.getPr_id(),userinfos.getU_pwd(),userinfos.getU_name(),userinfos.getU_title(),userinfos.getU_age(),userinfos.getU_sex(),userinfos.getU_tel(),userinfos.getU_taskstate(),userinfos.getU_email(),userinfos.getU_exp(),userinfos.getU_id()};
			boolean rs =DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("用户修改成功");
				return true;
			}else {
				System.out.println("用户修改失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
		
	}

	@Override
	public List<Userinfos> userFindAll() {
		try {
			
			String sql = "select * from t_userinfos u left join t_section s on u.s_id=s.s_id";
			Object[] obj = {};
			ResultSet rs = DBHelper.getRs(sql, obj);
			List<Userinfos> userList = new ArrayList<Userinfos>();
			while(rs.next()) {
				String u_id = rs.getString("u_id");
				int s_id = rs.getInt("s_id");
				String pr_id = rs.getString("pr_id");
				String u_pwd = rs.getString("u_pwd");
				String u_name = rs.getString("u_name");
				int u_title = rs.getInt("u_title");
				int u_age = rs.getInt("u_age");
				String u_sex = rs.getString("u_sex");
				String u_tel = rs.getString("u_tel");
				int u_taskstate = rs.getInt("u_taskstate");
				String u_email = rs.getString("u_email");
				String u_exp = rs.getString("u_exp");
				String s_name = rs.getString("s_name");
				String s_addr = rs.getString("s_addr");
				Section section = new Section();
				section.setS_addr(s_addr);
				section.setS_name(s_name);
				Userinfos userinfos = new Userinfos(u_id,s_id,pr_id,u_pwd,u_name,u_title,u_age,u_sex,u_tel,u_taskstate,u_email,u_exp);
				userinfos.setSection(section);
				userList.add(userinfos);
			}
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Userinfos userLogin(String u_id, String u_pwd) {
	
		try {
			
			String sql = "select * from t_userinfos where u_id=? and u_pwd=?";
			Object[] obj = {u_id,u_pwd};
			ResultSet rs = DBHelper.getRs(sql, obj);
			if(rs.next()) {

				int s_id = rs.getInt("s_id");
				String pr_id = rs.getString("pr_id");
				String u_name = rs.getString("u_name");
				int u_title = rs.getInt("u_title");
				int u_age = rs.getInt("u_age");
				String u_sex = rs.getString("u_sex");
				String u_tel = rs.getString("u_tel");
				int u_taskstate = rs.getInt("u_taskstate");
				String u_email = rs.getString("u_email");
				String u_exp = rs.getString("u_exp");
				Userinfos userinfos = new Userinfos(u_id,s_id,pr_id,u_pwd,u_name,u_title,u_age,u_sex,u_tel,u_taskstate,u_email,u_exp);
				return userinfos;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public Userinfos userFindByUid(String u_id) {		
		try {
			
			String sql = "select * from t_userinfos where u_id=?";
			Object[] obj = {u_id};
			ResultSet rs = DBHelper.getRs(sql, obj);
			if(rs.next()) {

				int s_id = rs.getInt("s_id");
				String pr_id = rs.getString("pr_id");
				String u_name = rs.getString("u_name");
				String u_pwd = rs.getString("u_pwd");
				int u_title = rs.getInt("u_title");
				int u_age = rs.getInt("u_age");
				String u_sex = rs.getString("u_sex");
				String u_tel = rs.getString("u_tel");
				int u_taskstate = rs.getInt("u_taskstate");
				String u_email = rs.getString("u_email");
				String u_exp = rs.getString("u_exp");
				Userinfos userinfos = new Userinfos(u_id,s_id,pr_id,u_pwd,u_name,u_title,u_age,u_sex,u_tel,u_taskstate,u_email,u_exp);
				return userinfos;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public boolean userUpPwd(String u_id, String u_pwd) {


		try {
			String sql = "update t_userinfos set u_pwd=? where u_id=?";
			
			Object[] obj = {u_pwd,u_id};
			boolean rs =DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("密码修改成功");
				return true;
			}else {
				System.out.println("密码修改失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
		
	
	}

	@Override
	public List<Userinfos> userFindDoctor() {

		try {
			String sql = "select * from t_userinfos u , t_section s where u.s_id=s.s_id and u.pr_id='pr1'";
			Object[] obj = {};
			ResultSet rs = DBHelper.getRs(sql, obj);
			List<Userinfos> userList = new ArrayList<Userinfos>();
			while(rs.next()) {
				String u_id = rs.getString("u_id");
				int s_id = rs.getInt("s_id");
				String pr_id = rs.getString("pr_id");
				String u_pwd = rs.getString("u_pwd");
				String u_name = rs.getString("u_name");
				int u_title = rs.getInt("u_title");
				int u_age = rs.getInt("u_age");
				String u_sex = rs.getString("u_sex");
				String u_tel = rs.getString("u_tel");
				int u_taskstate = rs.getInt("u_taskstate");
				String u_email = rs.getString("u_email");
				String u_exp = rs.getString("u_exp");
				String s_name = rs.getString("s_name");
				String s_addr = rs.getString("s_addr");
				Section section = new Section();
				section.setS_addr(s_addr);
				section.setS_name(s_name);
				Userinfos userinfos = new Userinfos(u_id,s_id,pr_id,u_pwd,u_name,u_title,u_age,u_sex,u_tel,u_taskstate,u_email,u_exp);
				userinfos.setSection(section);
				userList.add(userinfos);
			}
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public List<Userinfos> userFindByUname(String u_name) {		
		try {
			
			String sql = "select * from t_userinfos u , t_section s where u.s_id=s.s_id and u.u_name like ?";
			Object[] obj = {"%"+u_name+"%"};
			ResultSet rs = DBHelper.getRs(sql, obj);
			List<Userinfos> userList = new ArrayList<Userinfos>();
			while(rs.next()) {
				String u_id = rs.getString("u_id");
				String u_name1 = rs.getString("u_name");
				int s_id = rs.getInt("s_id");
				String pr_id = rs.getString("pr_id");
				String u_pwd = rs.getString("u_pwd");
				int u_title = rs.getInt("u_title");
				int u_age = rs.getInt("u_age");
				String u_sex = rs.getString("u_sex");
				String u_tel = rs.getString("u_tel");
				int u_taskstate = rs.getInt("u_taskstate");
				String u_email = rs.getString("u_email");
				String u_exp = rs.getString("u_exp");
				String s_name = rs.getString("s_name");
				String s_addr = rs.getString("s_addr");
				Section section = new Section();
				section.setS_addr(s_addr);
				section.setS_name(s_name);
				Userinfos userinfos = new Userinfos(u_id,s_id,pr_id,u_pwd,u_name1,u_title,u_age,u_sex,u_tel,u_taskstate,u_email,u_exp);
				userinfos.setSection(section);
				userList.add(userinfos);
			}
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
}

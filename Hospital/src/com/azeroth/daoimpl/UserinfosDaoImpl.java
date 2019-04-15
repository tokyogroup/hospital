package com.azeroth.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.azeroth.bean.Section;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.UserinfosDao;
import com.azeroth.utils.DBHelper;

public class UserinfosDaoImpl implements UserinfosDao{

	@Override
	public boolean userAdd(UserinfosDao userinfos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userDelete(String u_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userUpdate(UserinfosDao userinfos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Userinfos> userFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean userLogin(String u_id, String u_pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Userinfos userFindByUid(String u_id) {
		String sql="select * from t_userinfos where u_id=?";
		Object[] obj = {u_id};
		ResultSet rs= DBHelper.getResultSet(sql, obj);
		try {
			if(rs.next()) {
				int s_id=rs.getInt("s_id");
				Section section = new SectionDaoImpl().querySectionbyId(s_id);
				String pr_id=rs.getString("pr_id");
				String u_pwd=rs.getString("u_pwd");
				String u_name=rs.getString("u_name");
				int u_title=rs.getInt("u_title");
				int u_age =rs.getInt("u_age");
				String u_sex= rs.getString("u_sex");
				String u_tel=rs.getString("u_tel");
				int u_taskstate=rs.getInt("u_taskstate");
				String u_email=rs.getString("u_email");
				String u_exp=rs.getString("u_exp");
				Userinfos userinfos= new Userinfos(u_id, section, pr_id, u_pwd, u_name, u_title, u_age, u_sex, u_tel, u_taskstate, u_email, u_exp);
				return userinfos;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return null;
	}

	@Override
	public boolean userUpPwd(String u_id, String u_pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Userinfos> userFindDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override//查找同个部门的医生
	public List<Userinfos> userFindDoctorbysid(int s_id) {
		//u_id  s_id  pr_id u_pwd u_name u_titl u_age u_sex u_te u_taskstate u_email u_exp
		String sql="select * from t_userinfos where s_id=?";
		Object[] obj = {s_id};
		ResultSet rs= DBHelper.getResultSet(sql, obj);
		List<Userinfos> samesecdocList =new ArrayList<Userinfos>();
		Section section = new SectionDaoImpl().querySectionbyId(s_id);
		try {
			while(rs.next()) {
				String u_id=rs.getString("u_id");
				String pr_id=rs.getString("pr_id");
				String u_pwd=rs.getString("u_pwd");
				String u_name=rs.getString("u_name");
				int u_title=rs.getInt("u_title");
				int u_age =rs.getInt("u_age");
				String u_sex= rs.getString("u_sex");
				String u_tel=rs.getString("u_tel");
				int u_taskstate=rs.getInt("u_taskstate");
				String u_email=rs.getString("u_email");
				String u_exp=rs.getString("u_exp");
				Userinfos userinfos= new Userinfos(u_id, section, pr_id, u_pwd, u_name, u_title, u_age, u_sex, u_tel, u_taskstate, u_email, u_exp);
				samesecdocList.add(userinfos);
			}
			return samesecdocList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return null;
	}

}

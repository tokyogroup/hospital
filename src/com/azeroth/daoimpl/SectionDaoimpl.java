package com.azeroth.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azeroth.bean.Section;
import com.azeroth.bean.Userinfos;
import com.azeroth.dao.SectionDao;
import com.azeroth.utils.DBHelper;

public class SectionDaoimpl implements SectionDao {

	@Override
	public List<Section> sectionFindAll() {
		try {
			
			String sql = "select * from t_section";
			Object[] obj = {};
			ResultSet rs = DBHelper.getRs(sql, obj);
			List<Section> sectionList = new ArrayList<Section>();
			while(rs.next()) {
				int s_id = rs.getInt("s_id");
				String s_name = rs.getString("s_name");
				String s_addr = rs.getString("s_addr");
				Section seciton = new Section(s_id,s_name,s_addr);
				sectionList.add(seciton);	
			}
			return sectionList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void sectionAdd(Section section) {

		try {
			String sql = "insert into t_section values(default,?,?)";
			
			Object[] obj = {section.getS_name(),section.getS_addr()};
			boolean rs =DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("科室添加成功");
		
			}else {
				System.out.println("科室添加失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		
	}

	@Override
	public void sectionUpdate(Section section) {
		


		try {
			String sql = "update t_section set s_name=?,s_addr=? where s_id=?";
			
			Object[] obj = {section.getS_name(),section.getS_addr(),section.getS_id()};
			boolean rs =DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("科室修改成功");
				
			}else {
				System.out.println("科室修改失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		
	
	}

	@Override
	public Section sectionFindBySid(int s_id) {

		try {
			
			String sql = "select * from t_section where s_id=?";
			Object[] obj = {s_id};
			ResultSet rs = DBHelper.getRs(sql, obj);
			
			if(rs.next()) {
				
				String s_name = rs.getString("s_name");
				String s_addr = rs.getString("s_addr");
				Section seciton = new Section(s_id,s_name,s_addr);
				return 	seciton;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

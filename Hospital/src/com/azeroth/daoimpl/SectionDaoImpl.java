package com.azeroth.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.azeroth.bean.Section;
import com.azeroth.dao.SectionDao;
import com.azeroth.utils.DBHelper;

public class SectionDaoImpl implements SectionDao {

	@Override
	public Section querySectionbyId(int s_id) {
	  String sql="select * from t_section where s_id=?";
	  Object[]obj= {s_id};
	  ResultSet rs= DBHelper.getResultSet(sql, obj);
	  try {
		if(rs.next()) {
		  String s_name = rs.getString("s_name");
		  String s_addr= rs.getString("s_addr");
		  Section section = new Section(s_id, s_name, s_addr);
		  return section;
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public List<Section> querySections() {
		String sql="select * from t_section";
		Object[] obj= {};
		ResultSet rs= DBHelper.getResultSet(sql, obj);
		List<Section> sectionList = new ArrayList<Section>();
		try {
			while(rs.next()) {
				int s_id= rs.getInt("s_id");
				String s_name = rs.getString("s_name");
				String s_addr= rs.getString("s_addr");
				Section section = new Section(s_id, s_name, s_addr);
				sectionList.add(section);
			}
			return sectionList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}

package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Section;

public interface SectionDao {
	List<Section> sectionFindAll();//查看所有科室
	void sectionAdd(Section section);//添加科室
	void sectionUpdate(Section section);//修改科室
	Section sectionFindBySid(int s_id);//根据id查询科室
	
}

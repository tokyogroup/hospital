package com.azeroth.dao;


import java.util.ArrayList;
import java.util.List;

import com.azeroth.bean.Section;

public interface SectionDao {
	Section querySectionbyId(int s_id);
	List<Section> querySections();
}

package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Case1;

public interface Case1Dao {
	List<Case1> case1FindAll();//查看所有病例
	List<Case1> case1FindByPiId(String pi_id);//根据就诊卡号查看病例
	void case1Add(Case1 case1);//病例添加
	void case1Update(Case1 case1);//修改病例 当病例状态为0 的时候
	Case1 case1FindByCid(String c_id);//根据cid 查询病例
	
	
	
}

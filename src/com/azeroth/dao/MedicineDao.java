package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Medicine;

public interface MedicineDao {
	//增加药品信息
	public void addMedicine(Medicine me);
	//删除药品信息
	public void delMedicine(String name);
	//修改药品信息
	public void modMedicine(Medicine me);
	//查询药品信息列表
	public List<Medicine> findAll();
	//根据药品名称查询
	public List<Medicine> findAll(String name);
}

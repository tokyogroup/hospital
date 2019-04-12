package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Patients;

public interface RegistrationDao {
	//查询
	public List<RegistrationDao> queryRigistration();
	//添加
	public boolean addRegistration(RegistrationDao registration);
	//修改
	public boolean updateRegistration(String rg_id);
	//删除退号
	public boolean delRegistration(String rg_id);
}

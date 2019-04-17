package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Patients;
import com.azeroth.bean.Registration;

public interface RegistrationDao {
	//查询
	public List<Registration> queryRigistration(String condition);
	//添加
	public boolean addRegistration(Registration registration);
	//修改
	public boolean updateRegistration(String rg_id);
	//删除退号
	public boolean delRegistration(String rg_id);
	//修改挂号状态
	public boolean updateStatusRegistration(String rg_id);
}

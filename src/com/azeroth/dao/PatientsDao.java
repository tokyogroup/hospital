package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Patients;

public interface PatientsDao {
	//增删改查
	void  addPatient(Patients pa);
	void  delPatient(String name);
	void  modPatient(Patients pa);
	List<Patients> findAll();
	List<Patients> findByName(String pi_name);
	Patients findById(String pi_id);
}
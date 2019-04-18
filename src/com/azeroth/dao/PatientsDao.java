package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Patients;

public interface PatientsDao {
	//增删改查
	void  addPatient(Patients pa);
	boolean  delPatient(String pi_id);
	void  modPatient(String pi_tele,String pi_addr,String pi_id);
	List<Patients> findAll();
	List<Patients> findByName(String pi_name);
	Patients findById(String pi_id);
	List<Patients> queryPatients(String condition);
}
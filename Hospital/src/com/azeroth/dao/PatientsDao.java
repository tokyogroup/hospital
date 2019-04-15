package com.azeroth.dao;

import com.azeroth.bean.Patients;

public interface PatientsDao {
	boolean addPatients(Patients patients);
	Patients queryPatientsbyid(String pi_id);
}

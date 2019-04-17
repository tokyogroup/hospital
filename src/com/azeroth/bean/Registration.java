package com.azeroth.bean;
//挂号
public class Registration {
	//registr表字段rg_id pi_id u_id u_id2 rg_price rg_date  rg_status

	private String rg_id;	     //挂号编号 
	private Patients patients;	     //就诊号
	private String u_id;         //门诊人员编号
	private Userinfos userinfos;        //医生编号       
	private double rg_price;     //挂号费   
	private String rg_date;      //挂号时间
	private int rg_status;       //挂号状态	
	public String getRg_id() {
		return rg_id;
	}
	public void setRg_id(String rg_id) {
		this.rg_id = rg_id;
	}
	public Patients getPatients() {
		return patients;
	}
	public void setPatients(Patients patients) {
		this.patients = patients;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public Userinfos getUserinfos() {
		return userinfos;
	}
	public void setUserinfos(Userinfos userinfos) {
		this.userinfos = userinfos;
	}
	public double getRg_price() {
		return rg_price;
	}
	public void setRg_price(double rg_price) {
		this.rg_price = rg_price;
	}
	public String getRg_date() {
		return rg_date;
	}
	public void setRg_date(String rg_date) {
		this.rg_date = rg_date;
	}
	public int getRg_status() {
		return rg_status;
	}
	public void setRg_status(int rg_status) {
		this.rg_status = rg_status;
	}
	public Registration(String rg_id, Patients patients, String u_id, Userinfos userinfos, double rg_price,
			String rg_date, int rg_status) {
		super();
		this.rg_id = rg_id;
		this.patients = patients;
		this.u_id = u_id;
		this.userinfos = userinfos;
		this.rg_price = rg_price;
		this.rg_date = rg_date;
		this.rg_status = rg_status;
	}
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
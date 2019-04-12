package com.azeroth.bean;

public class Registration {
	//registr表字段rg_id pi_id u_id u_id2 rg_price rg_date  rg_status

	String rg_id;	     //挂号编号 
	String pi_id;	     //就诊号
	Userinfos userinfos; //医生    
	double rg_price;     //挂号费   
	String rg_date;      //挂号时间
	int rg_status;       //挂号状态	
	public Registration(String rg_id, String pi_id, Userinfos userinfos,  double rg_price,
			String rg_date, int rg_status) {
		super();
		this.rg_id = rg_id;
		this.pi_id = pi_id;
		this.userinfos = userinfos;
		this.rg_price = rg_price;
		this.rg_date = rg_date;
		this.rg_status = rg_status;
	}
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRg_id() {
		return rg_id;
	}
	public void setRg_id(String rg_id) {
		this.rg_id = rg_id;
	}
	public String getPi_id() {
		return pi_id;
	}
	public void setPi_id(String pi_id) {
		this.pi_id = pi_id;
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
    
}

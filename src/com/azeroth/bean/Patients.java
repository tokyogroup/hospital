package com.azeroth.bean;

public class Patients {
	private String pi_id;
	private String pi_name;
	private String pi_sex;
	private int pi_age;
	public Patients() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patients(String pi_id, String pi_name, String pi_sex, int pi_age) {
		super();
		this.pi_id = pi_id;
		this.pi_name = pi_name;
		this.pi_sex = pi_sex;
		this.pi_age = pi_age;
	}
	public String getPi_id() {
		return pi_id;
	}
	public void setPi_id(String pi_id) {
		this.pi_id = pi_id;
	}
	public String getPi_name() {
		return pi_name;
	}
	public void setPi_name(String pi_name) {
		this.pi_name = pi_name;
	}
	public String getPi_sex() {
		return pi_sex;
	}
	public void setPi_sex(String pi_sex) {
		this.pi_sex = pi_sex;
	}
	public int getPi_age() {
		return pi_age;
	}
	public void setPi_age(int pi_age) {
		this.pi_age = pi_age;
	}
	
	
	

}
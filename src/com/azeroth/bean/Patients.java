package com.azeroth.bean;

public class Patients {
	
	private String pi_id;
	private String pi_name;
	private String pi_sex;
	private int pi_age;
	private String pi_date;
	private String pi_tele;
	private String pi_addr;
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
	public String getPi_date() {
		return pi_date;
	}
	public void setPi_date(String pi_date) {
		this.pi_date = pi_date;
	}
	public String getPi_tele() {
		return pi_tele;
	}
	public void setPi_tele(String pi_tele) {
		this.pi_tele = pi_tele;
	}
	public String getPi_addr() {
		return pi_addr;
	}
	public void setPi_addr(String pi_addr) {
		this.pi_addr = pi_addr;
	}
	public Patients(String pi_id, String pi_name, String pi_sex, int pi_age, String pi_date, String pi_tele,
			String pi_addr) {
		super();
		this.pi_id = pi_id;
		this.pi_name = pi_name;
		this.pi_sex = pi_sex;
		this.pi_age = pi_age;
		this.pi_date = pi_date;
		this.pi_tele = pi_tele;
		this.pi_addr = pi_addr;
	}
	public Patients() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

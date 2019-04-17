package com.azeroth.bean;
//病例处方表
public class Recipe {
	private String rc_id;
	private Medicine medicine;
	private int rc_count;
	private Case1 case1;
	public Recipe(String rc_id, Medicine medicine, int rc_count, Case1 case1) {
		super();
		this.rc_id = rc_id;
		this.medicine = medicine;
		this.rc_count = rc_count;
		this.case1 = case1;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public String getRc_id() {
		return rc_id;
	}
	public void setRc_id(String rc_id) {
		this.rc_id = rc_id;
	}
	
	public int getRc_count() {
		return rc_count;
	}
	public void setRc_count(int rc_count) {
		this.rc_count = rc_count;
	}
	public Case1 getCase1() {
		return case1;
	}
	public void setCase1(Case1 case1) {
		this.case1 = case1;
	}
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}

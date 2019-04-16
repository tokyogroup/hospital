package com.azeroth.bean;
//病例处方表
public class Recipe {
	private String rc_id;
	private String m_id;
	private int rc_count;
	private Case1 case1;
	public String getRc_id() {
		return rc_id;
	}
	public void setRc_id(String rc_id) {
		this.rc_id = rc_id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
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
	public Recipe(String rc_id, String m_id, int rc_count, Case1 case1) {
		super();
		this.rc_id = rc_id;
		this.m_id = m_id;
		this.rc_count = rc_count;
		this.case1 = case1;
	}
	
}

package com.azeroth.bean;

import java.util.ArrayList;
import java.util.List;

//病例
public class Case1 {
	private String c_id;
	private Patients patients;
	private Userinfos userinfos;
	private String c_date;
	private String c_result;
	private String c_method;
	private int c_status;
	private List<Recipe> recipeList = new ArrayList<Recipe>();
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public Patients getPatients() {
		return patients;
	}
	public void setPatients(Patients patients) {
		this.patients = patients;
	}
	public Userinfos getUserinfos() {
		return userinfos;
	}
	public List<Recipe> getRecipeList() {
		return recipeList;
	}
	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	public void setUserinfos(Userinfos userinfos) {
		this.userinfos = userinfos;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	public String getC_result() {
		return c_result;
	}
	public void setC_result(String c_result) {
		this.c_result = c_result;
	}
	public String getC_method() {
		return c_method;
	}
	public void setC_method(String c_method) {
		this.c_method = c_method;
	}
	public int getC_status() {
		return c_status;
	}
	public void setC_status(int c_status) {
		this.c_status = c_status;
	}
	public Case1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Case1(String c_id, Patients patients, Userinfos userinfos, String c_date, String c_result, String c_method,
			int c_status) {
		super();
		this.c_id = c_id;
		this.patients = patients;
		this.userinfos = userinfos;
		this.c_date = c_date;
		this.c_result = c_result;
		this.c_method = c_method;
		this.c_status = c_status;
	}
	
	
}

package com.azeroth.bean;

public class Section {
	private int s_id;
	private String s_name;
	private String s_addr;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_addr() {
		return s_addr;
	}
	public void setS_addr(String s_addr) {
		this.s_addr = s_addr;
	}
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Section(int s_id, String s_name, String s_addr) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_addr = s_addr;
	}
	
}

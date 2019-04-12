package com.azeroth.bean;

public class Medicine {
	private String m_id;
	private String m_name;
	private String m_spec;
	private double m_price;
	private String m_function;
	private String m_addr;
	private String m_count;
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine(String m_id, String m_name, String m_spec, double m_price, String m_function, String m_addr,
			String m_count) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_spec = m_spec;
		this.m_price = m_price;
		this.m_function = m_function;
		this.m_addr = m_addr;
		this.m_count = m_count;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_spec() {
		return m_spec;
	}
	public void setM_spec(String m_spec) {
		this.m_spec = m_spec;
	}
	public double getM_price() {
		return m_price;
	}
	public void setM_price(double m_price) {
		this.m_price = m_price;
	}
	public String getM_function() {
		return m_function;
	}
	public void setM_function(String m_function) {
		this.m_function = m_function;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public String getM_count() {
		return m_count;
	}
	public void setM_count(String m_count) {
		this.m_count = m_count;
	}
	
	
}

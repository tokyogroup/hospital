package com.azeroth.bean;

public class Order {
	private String o_id;
	private double total;
	private int o_status;
	private Case1 case1;
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getO_status() {
		return o_status;
	}
	public void setO_status(int o_status) {
		this.o_status = o_status;
	}
	public Case1 getCase1() {
		return case1;
	}
	public void setCase1(Case1 case1) {
		this.case1 = case1;
	}
	public Order(String o_id, double total, int o_status, Case1 case1) {
		super();
		this.o_id = o_id;
		this.total = total;
		this.o_status = o_status;
		this.case1 = case1;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

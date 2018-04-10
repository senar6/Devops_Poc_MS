package com.tcs.spring.model;

public class WorkOrder{

	//int wid;
	String name;
	String area;
	String woarea;
	int woorderno;
	public WorkOrder(){}
	public WorkOrder(String name, String area, String woarea,
			int woorderno) {
		super();
		this.name = name;
		this.area = area;
		this.woarea = woarea;
		this.woorderno = woorderno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getWoarea() {
		return woarea;
	}
	public void setWoarea(String woarea) {
		this.woarea = woarea;
	}
	public int getWoorderno() {
		return woorderno;
	}
	public void setWoorderno(int woorderno) {
		this.woorderno = woorderno;
	}
	
}
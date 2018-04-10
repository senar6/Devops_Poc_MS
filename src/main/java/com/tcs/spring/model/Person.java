package com.tcs.spring.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author Ram
 * 
 */
public class Person {

	int id;
	String name;
	String country;

	public Person(){}

	public Person(int id, String name, String country) {
		// TODO Auto-generated constructor stub
		super();
		this.id= id;
		this.name= name;
		this.country= country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return "ID: " + id + " Name: " + name + " Country: " + country;
	}
}
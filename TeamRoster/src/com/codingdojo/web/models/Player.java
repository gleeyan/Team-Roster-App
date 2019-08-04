package com.codingdojo.web.models;

public class Player implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
//	Attributes
	private String first_name;
	private String last_name;
	private int age;
	
//	Constructors
	protected Player() {
		
	}
	public Player(String first, String last, int age) {
		this.first_name = first;
		this.last_name = last;
		this.age = age;
	}
	
//	Getters
	public String getFirst() {
		return this.first_name;
	}
	public String getLast() {
		return this.last_name;
	}
	public int getAge() {
		return this.age;
	}
	
//	Setters
	public void setFirst(String first) {
		this.first_name = first;
	}
	public void setLast(String last) {
		this.last_name = last;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
//	Method
	public void printDetails() {
		System.out.println(this.getFirst() + " " + this.getLast() + " " + this.getAge());
	}
}

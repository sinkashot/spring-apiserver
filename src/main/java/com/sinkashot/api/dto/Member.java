package com.sinkashot.api.dto;

public class Member {
	private int number;
	private String id;
	private String name;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "member{"+
				"number='"+this.number+'\''+
				", id='"+this.id+'\''+
				", name='"+this.name+'\''+
				"}";
	}
}

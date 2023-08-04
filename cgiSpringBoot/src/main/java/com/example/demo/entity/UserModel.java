package com.example.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
	private int id;
	private String name;
	private String role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(int id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	
}

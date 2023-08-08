package com.example.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beanmodel.album;

public interface albuminterface {

	public album addalbum(album a);
	public List<album> getallalbum();
	public album updatealbum(album a);
	public album deletealbum(String albumid);
	public album getalbumbyid(String albumid);
	public List<album> getallalbumsbysinger(String singername);
	
}

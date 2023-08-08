package com.example.demo.beanmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class album {
	@Id
	@Column(name="id")
	private String albumid;
	private String albumnae;
	private String singer;
	private double price;
	private String language;

	public album(String albumid, String albumnae, String singer, double price, String language) {
		super();
		this.albumid = albumid;
		this.albumnae = albumnae;
		this.singer = singer;
		this.price = price;
		this.language = language;
	}
	
	
	public String getAlbumid() {
		return albumid;
	}
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}
	public String getAlbumnae() {
		return albumnae;
	}
	public void setAlbumnae(String albumnae) {
		this.albumnae = albumnae;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}


	public album() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

package com.example.springBootProj2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Player {
	@Id
	@Column(name="id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int playerId;
	private String playerName;
	private String sports;
	private String country;
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(int playerId, String playerName, String sports, String country) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.sports = sports;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", sports=" + sports + ", country="
				+ country + "]";
	}
	
	

}

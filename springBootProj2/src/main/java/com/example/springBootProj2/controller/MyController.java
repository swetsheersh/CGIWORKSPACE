package com.example.springBootProj2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootProj2.dao.PlayerDao;
import com.example.springBootProj2.entity.Player;
import com.example.springBootProj2.exception.MyException;

@RestController
public class MyController {
	@Autowired
	private PlayerDao playerDao;
	@RequestMapping(path="/addplayer", method = RequestMethod.POST)
	public String addPlayer(@RequestBody Player player) throws MyException {
		System.out.println(player);
		//update existing player
		if(playerDao.existsById(player.getPlayerId())) {
			Player p=playerDao.getById(player.getPlayerId());
			p.setPlayerName(player.getPlayerName());
			p.setCountry(player.getCountry());
			p.setSports(player.getSports());
			playerDao.save(p);
			return "Player Details updated successfully";
		}
		Player id;
		if(playerDao.existsById(player.getPlayerId())) {
			throw new MyException();
		}
		try {
			id = playerDao.save(player);
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
			throw new MyException();
		}
		return "Player Added Successfully with id: "+id.getPlayerId();
	}
	@GetMapping(path = "/getall")
	public List<Player> getAllPlayer(){
		return playerDao.findAll();
	}
}

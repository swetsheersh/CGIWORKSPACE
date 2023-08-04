package com.example.demo.mycontroller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyController {
	@RequestMapping(path = "/api/v1/player" ,method = RequestMethod.GET)
	public String msg() {
		return "All players returned";
	}
	@GetMapping(path = "/api/v1/player/{playerid}")
	public String getUser(@PathVariable("playerid") String playerid) {
		return "Player("+playerid+") returned";
		
	}
}

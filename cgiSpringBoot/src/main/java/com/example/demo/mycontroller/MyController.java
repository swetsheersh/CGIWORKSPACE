package com.example.demo.mycontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserModel;

import jakarta.websocket.server.PathParam;

@RestController
public class MyController {
	@RequestMapping(path = "/user" ,method = RequestMethod.GET)
	public String msg() {
		return "welcome to springBoot";
	}
	@GetMapping(path = "/getuser")
	public UserModel getUser() {
		UserModel um=new UserModel();
		um.setId(10);
		um.setName("swet");
		um.setRole("Software Engineer");
		return um;
	}
	@GetMapping(path="/req")
	public String queryParam(@PathParam("page") Integer page) {
		return "You are at page: "+page;
	}
	@GetMapping(path="/req1")
	public String queryParam1(@RequestParam("page") Integer page) {
		return "You are at page: "+page;
	}
}

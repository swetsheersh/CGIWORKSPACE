package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beanmodel.album;
import com.example.demo.services.albumservices;

@RestController
public class albumcontroller {

	@Autowired
	private albumservices as;
	
	@PostMapping(path="/add")
	public ResponseEntity<?> addalbum(@RequestBody album al){
		System.out.println(al);
		
		album alb=as.addalbum(al);
		if(alb!=null) {
			return new ResponseEntity<album>(al,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("album not created",HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(path = "/getall")
	public ResponseEntity<?> getallalbum(){
		List<album> alist=as.getallalbum();
		if(alist.size()>0) {
			return new ResponseEntity<List<album>>(alist,HttpStatus.OK);
		}
		return new ResponseEntity<String>("List is empty",HttpStatus.CONFLICT);	
	}
	
	@PostMapping(path="/update")
	public ResponseEntity<?> updatealbum(@RequestBody album a1){
		album upal=as.updatealbum(a1);
		if(upal!=null) {
			return new ResponseEntity<album>(upal,HttpStatus.OK);
		}
		return new ResponseEntity<String>("album not updated",HttpStatus.OK);
	}
	
	@GetMapping("/delby/{albumid}")
	public ResponseEntity<?> deletealbum(@PathVariable("albumid") String albumid){
		album delalb=as.deletealbum(albumid);
		if(delalb!=null) {
			return new ResponseEntity<album>(delalb,HttpStatus.OK);
		}
		return new ResponseEntity<String>("album not declared",HttpStatus.OK);
	}
	@GetMapping("/getby/{albumid}")
	public ResponseEntity<?> getalbumbyid(@PathVariable("albumid") String albumid){
		album getid=as.getalbumbyid(albumid);
		if(getid!=null) {
			return new ResponseEntity<album>(getid,HttpStatus.OK);
		}
		return new ResponseEntity<String>("album not found",HttpStatus.OK);
	}
}

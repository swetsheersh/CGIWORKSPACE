package com.example.demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.*;
import com.example.demo.beanmodel.album;

@Service
public class albumservices implements albuminterface{

	@Autowired
	private albumrepository albumrepository;
	
	@Override
	public album addalbum(album a ) {
		album album1=albumrepository.save(a);
		return album1;
	}

	@Override
	public List<album> getallalbum() {
		// TODO Auto-generated method stub
		return albumrepository.findAll();
	}

	@Override
	public album updatealbum(album a) {
		// TODO Auto-generated method stub
		if(albumrepository.existsById(a.getAlbumid())) {
		return null;
	}
		albumrepository.save(a);
		return a;
	}

	@Override
	public album deletealbum(String albumid) {
		// TODO Auto-generated method stub
		if(albumrepository.existsById(albumid)) {
			album alb=albumrepository.findById(albumid).get();
			albumrepository.deleteById(albumid);
			return alb;
		}
		return null;
	}

	@Override
	public album getalbumbyid(String albumid) {
		Optional<album> albumdata = albumrepository.findById(albumid);
		if(albumdata.isPresent()) {
			return albumdata.get();
		}else {
			return null;
		}
	}

	@Override
	public List<album> getallalbumsbysinger(String singername) {
		// TODO Auto-generated method stub
		return null;
	}

}

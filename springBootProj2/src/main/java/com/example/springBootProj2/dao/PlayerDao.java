package com.example.springBootProj2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.springBootProj2.entity.Player;
@Service
public interface PlayerDao extends JpaRepository<Player, Integer> {

}

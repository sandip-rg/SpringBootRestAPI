package com.spring.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.rest.dao.BikeDao;
import com.spring.rest.model.Bike;

@Component
public class BikeService {
	@Autowired
	private BikeDao bikeDao;
	
	//get all bikes
	public List<Bike> getAllBikes(){
		List<Bike> bikeList =(List<Bike>) this.bikeDao.findAll();
		return bikeList;
	}
	
	//get bike by id
	public Bike getBikeById(int id) {
		Bike findById = this.bikeDao.findById(id);
		return findById;
	}
	
	//adding the bike
	public Bike addBike(Bike b) {
		Bike result = this.bikeDao.save(b);
		return result;
	}
	
	//delete bike
	public void deleteBike(int id) {
		this.bikeDao.deleteById(id);
	}
	
	//update bike
	public void updateBike(Bike bike,int id) {
		bike.setId(id);
		this.bikeDao.save(bike);
	}
}

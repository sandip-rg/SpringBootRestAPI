package com.spring.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.rest.model.Bike;

public interface BikeDao extends CrudRepository<Bike, Integer> {
	public Bike findById(int id);
}

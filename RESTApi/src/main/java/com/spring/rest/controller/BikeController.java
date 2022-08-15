package com.spring.rest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.model.Bike;
import com.spring.rest.services.BikeService;

@RestController
public class BikeController {
	@Autowired
	private BikeService bikeService;

	// get all bikes
	@GetMapping("/bikes")
	public ResponseEntity<List<Bike>> getAllBook() {
		List<Bike> allBikes = this.bikeService.getAllBikes();
		if (allBikes.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(allBikes);
	}

	// get bike by id
	@GetMapping("bikes/{id}")
	public ResponseEntity<Bike> getBikeById(@PathVariable("id") int id) {
		Bike bikeById = this.bikeService.getBikeById(id);
		if (bikeById == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(bikeById);
	}

	// create bike
	@PostMapping("/bikes")
	public ResponseEntity<Bike> addBike(@RequestBody Bike bike) {
		try {
			this.bikeService.addBike(bike);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// delete bike
	@DeleteMapping("/bikes/{id}")
	public ResponseEntity<Void> deleteBike(@PathVariable("id") int id) {

		try {
			this.bikeService.deleteBike(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/bikes/{id}")
	public ResponseEntity<Void> updateBike(@RequestBody Bike bike, @PathVariable("id") int id) {

		try {
			this.bikeService.updateBike(bike, id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}

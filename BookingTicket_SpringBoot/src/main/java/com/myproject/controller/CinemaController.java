package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.entity.Cinema;
import com.myproject.service.CinemaService;

@RestController
@RequestMapping("api/cinema")
public class CinemaController {

	@Autowired
	private CinemaService cinemaService;
	
	@GetMapping("all")
	@ResponseBody
	public ResponseEntity<List<Cinema>> all() {
		List<Cinema> cinemas = cinemaService.findAll();
		if(!cinemas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cinema>>(cinemas, HttpStatus.OK);
	}
}

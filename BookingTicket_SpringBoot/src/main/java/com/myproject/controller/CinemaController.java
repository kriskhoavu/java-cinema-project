package com.myproject.controller;

import com.myproject.entity.Cinema;
import com.myproject.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cinema")
public class CinemaController {
	@Autowired
	private CinemaService cinemaService;

	@ResponseBody
	@GetMapping("all")
	public ResponseEntity<List<Cinema>> all() {
		List<Cinema> response = cinemaService.findAll();
		return ResponseEntity.ok(response);
	}
}

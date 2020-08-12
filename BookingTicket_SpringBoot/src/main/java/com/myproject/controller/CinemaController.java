package com.myproject.controller;

import java.util.List;

import com.myproject.Util.ResponseUtil;
import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.entity.Cinema;
import com.myproject.service.CinemaService;

@RestController
@RequestMapping("api/cinema")
public class CinemaController {

	@Autowired
	private CinemaService cinemaService;

	@ResponseBody
	@GetMapping("all")
	public ResponseEntity<ResponseModel<List<Cinema>>> all() {
		ResponseModel<List<Cinema>> response = cinemaService.findAll();
		return new ResponseUtil<List<Cinema>>().createResponse(HttpStatus.OK, response);
	}
}

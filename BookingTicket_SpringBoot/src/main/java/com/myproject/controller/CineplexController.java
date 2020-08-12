package com.myproject.controller;

import java.util.List;

import javax.validation.constraints.Null;

import com.myproject.Util.ResponseUtil;
import com.myproject.model.common.CONSTANT;
import com.myproject.model.entity.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cineplex;
import com.myproject.service.CineplexService;

@RestController
@RequestMapping("api/cineplex")
public class CineplexController {
	@Autowired
	private CineplexService cineplexService;

	@GetMapping("all")
	public ResponseEntity<List<Cineplex>> all() {

		List<Cineplex> cineplexs = cineplexService.findAll();

		if (cineplexs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Cineplex>>(cineplexs, HttpStatus.OK);
	}

	@PostMapping("add")
	public ResponseEntity<ResponseModel> add(@Validated @RequestBody Cineplex cineplex, BindingResult errors) {
		ResponseModel<Null> response;

		if (errors.hasErrors()) {
			response = new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_FAILED, CONSTANT.API_RESPONSE_STATUS_DESC_REQUEST_MODEL);
			return new ResponseUtil<Null>().createResponse(HttpStatus.BAD_REQUEST, response);
		}

		response = cineplexService.insert(cineplex);
		return new ResponseUtil<Null>().createResponse(HttpStatus.OK, response);
	}

	@PutMapping("edit/{id}")
	public ResponseEntity<ResponseModel> edit(@PathVariable int id, @Validated @RequestBody Cineplex cineplex, BindingResult errors) {
		ResponseModel<Null> response;

		if (errors.hasErrors()) {
			response = new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_FAILED, CONSTANT.API_RESPONSE_STATUS_DESC_REQUEST_MODEL);
			return new ResponseUtil<Null>().createResponse(HttpStatus.BAD_REQUEST, response);
		}

		cineplex.setId(id);
		response = cineplexService.update(cineplex);
		return new ResponseUtil<Null>().createResponse(HttpStatus.OK, response);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<ResponseModel> delete(@PathVariable int id) {

		ResponseModel<Null> response = cineplexService.delete(id);

		return new ResponseUtil<Null>().createResponse(HttpStatus.OK, response);
	}

	@GetMapping("paging/{pageIndex}/{pageSize}")
	public Object paging(@PathVariable int pageIndex, @PathVariable int pageSize) {
	
	Page<Cineplex> cineplexs = cineplexService.findAllPaging(pageIndex - 1, pageSize);

		if (cineplexs.getSize() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Page<Cineplex>>(cineplexs, HttpStatus.OK);
	}
}

package com.myproject.controller;

import com.myproject.Util.ResponseUtil;
import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cineplex;
import com.myproject.service.CineplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
@RequestMapping("api/cineplex")
public class CineplexController {
	@Autowired
	private CineplexService cineplexService;

	@Autowired
	private ResponseUtil responseUtil;

	@GetMapping("all")
	public ResponseEntity all() {
		ResponseModel<List<Cineplex>> response;
		List<Cineplex> cineplexes = cineplexService.findAll();

		if (cineplexes.isEmpty()) {
			response = new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
			return responseUtil.createResponse(HttpStatus.NO_CONTENT, response);
		}

		response = new ResponseModel<>(
			CONSTANT.API_RESPONSE_STATUS_CODE_OK, 
			CONSTANT.API_RESPONSE_STATUS_DESC_OK, 
			cineplexes
		);
		
		return responseUtil.createResponse(HttpStatus.OK, response);
	}

	@PostMapping("add")
	public ResponseEntity add(@Validated @RequestBody Cineplex cineplex, BindingResult errors) {
		ResponseModel<Null> response;

		if (errors.hasErrors()) {
			response = new ResponseModel<>(CONSTANT.API_RESPONSE_STATUS_CODE_FAILED, CONSTANT.API_RESPONSE_STATUS_DESC_REQUEST_MODEL);
			return responseUtil.createResponse(HttpStatus.BAD_REQUEST, response);
		}

		response = cineplexService.insert(cineplex);
		return responseUtil.createResponse(HttpStatus.OK, response);
	}

	@PutMapping("edit/{id}")
	public ResponseEntity edit(@PathVariable int id, @Validated @RequestBody Cineplex cineplex, BindingResult errors) {
		ResponseModel<Null> response;

		if (errors.hasErrors()) {
			response = new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_FAILED, CONSTANT.API_RESPONSE_STATUS_DESC_REQUEST_MODEL);
			return responseUtil.createResponse(HttpStatus.BAD_REQUEST, response);
		}

		cineplex.setId(id);
		response = cineplexService.update(cineplex);
		return responseUtil.createResponse(HttpStatus.OK, response);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity delete(@PathVariable int id) {

		ResponseModel<Null> response = cineplexService.delete(id);

		return responseUtil.createResponse(HttpStatus.OK, response);
	}

	@GetMapping("paging/{pageIndex}/{pageSize}")
	public Object paging(@PathVariable int pageIndex, @PathVariable int pageSize) {
	
	Page<Cineplex> cineplexs = cineplexService.findAllPaging(pageIndex - 1, pageSize);

		if (cineplexs.getSize() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(cineplexs, HttpStatus.OK);
	}
}

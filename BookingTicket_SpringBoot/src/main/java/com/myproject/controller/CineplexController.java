package com.myproject.controller;

import java.util.List;

import javax.validation.constraints.Null;

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
	public Object add(@Validated @RequestBody Cineplex cineplex, BindingResult errors) {

		ResponseModel<Null> responseModel = new ResponseModel<Null>();

		if (errors.hasErrors()) {
			responseModel.setMessage("Request model is required.");
			responseModel.setHttpStatus(HttpStatus.BAD_REQUEST);
			return responseModel;
		}

		responseModel = cineplexService.insert(cineplex);

		if (!responseModel.isStatus()) {
			responseModel.setHttpStatus(HttpStatus.BAD_REQUEST);
			return responseModel;
		}
		responseModel.setHttpStatus(HttpStatus.CREATED);
		
		return responseModel;
	}

	@PutMapping("edit/{id}")
	public Object edit(@PathVariable int id, @Validated @RequestBody Cineplex cineplex, BindingResult errors) {

		ResponseModel<Null> responseModel = new ResponseModel<Null>();

		if (errors.hasErrors()) {
			responseModel.setMessage("Request model is required.");
			responseModel.setHttpStatus(HttpStatus.BAD_REQUEST);
			
			return responseModel;
		}

		cineplex.setId(id);
		responseModel = cineplexService.update(cineplex);

		if (!responseModel.isStatus()) {
			return responseModel;

		}
		responseModel.setHttpStatus(HttpStatus.OK);
		return responseModel;
	}
	
	@DeleteMapping("delete/{id}")
	public Object delete(@PathVariable int id) {

		ResponseModel<Null> responseModel = cineplexService.delete(id);

		if (!responseModel.isStatus()) {
			return new ResponseEntity<>(responseModel.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(responseModel.getMessage(), HttpStatus.OK);
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

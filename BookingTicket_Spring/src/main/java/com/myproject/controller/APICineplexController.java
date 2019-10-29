package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.common.BaseResponse;
import com.myproject.entity.Cineplex;
import com.myproject.service.ICineplexService;

@RestController
@RequestMapping("api/cineplex")
public class APICineplexController {

	@Autowired
	private ICineplexService _cineplexService;

	@GetMapping("")
	@ResponseBody
	public ResponseEntity<List<Cineplex>> all() {
		List<Cineplex> cineplexs = _cineplexService.findAll();
		if (cineplexs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cineplex>>(cineplexs, HttpStatus.OK);
	}

	@GetMapping("paging")
	@ResponseBody
	public ResponseEntity<Page<Cineplex>> paging(@PathVariable int pageIdx, @PathVariable int pageSize) {
		Page<Cineplex> cineplexs = _cineplexService.findAllPaging(pageIdx, pageSize);
		if (cineplexs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Cineplex>>(cineplexs, HttpStatus.OK);
	}

	@PostMapping("add")
	public Object add(@RequestBody Cineplex cineplex, BindingResult errors) {

		if (errors.hasErrors())
			return new ResponseEntity<>("Chưa nhập đủ thông tin.", HttpStatus.BAD_REQUEST);

		BaseResponse model = _cineplexService.insert(cineplex);

		if (!model.isStatus())
			return new ResponseEntity<>(model.getMessage(), HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(model.getMessage(), HttpStatus.CREATED);
	}

	@PutMapping("edit/{id}")
	public Object edit(@PathVariable int id, @RequestBody Cineplex cineplex, BindingResult errors) {

		if (errors.hasErrors())
			return new ResponseEntity<>("Chưa nhập đủ thông tin.", HttpStatus.BAD_REQUEST);

		cineplex.setId(id);
		BaseResponse model = _cineplexService.update(cineplex);

		if (!model.isStatus())
			return new ResponseEntity<>(model.getMessage(), HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(model.getMessage(), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public Object delete(@PathVariable int id, BindingResult errors) {
		if (errors.hasErrors())
			return new ResponseEntity<>("Chưa nhập đủ thông tin.", HttpStatus.BAD_REQUEST);
		BaseResponse model = _cineplexService.delete(id);

		if (!model.isStatus())
			return new ResponseEntity<>(model.getMessage(), HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(model.getMessage(), HttpStatus.OK);
	}
}

package com.myproject.admin.controller;

import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Movie;
import com.myproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@Controller
@RequestMapping("admin/movie")
public class AdminMovieController {
	@Autowired
	private MovieService movieService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("movies", movieService.findAll());
		return "movie/index";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("movie", new Movie());
		return "movie/add";
	}
	
	@PostMapping("add")
	public String add(Model model, 
			@Validated @ModelAttribute("movie") Movie movie,
			BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("movie", movie);
			return "movie/add";
		}
		ResponseModel<Null> errorModel = movieService.insert(movie);
		if(errorModel.getStatusCode() != CONSTANT.API_RESPONSE_STATUS_CODE_OK) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("movie", movie);
			return "movie/add";
		}
		
		return "redirect:/admin/movie";
		
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("movie", movieService.findById(id));
		return "movie/edit";
	}
	
	@PostMapping("edit")
	public String edit(Model model, 
			@Validated @ModelAttribute("movie") Movie movie,
			BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("movie", movie);
			return "movie/edit";
		}
		ResponseModel<Null> errorModel = movieService.update(movie);
		if(errorModel.getStatusCode() != CONSTANT.API_RESPONSE_STATUS_CODE_OK) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("movie", movie);
			return "movie/edit";
		}
		return "redirect:/admin/movie";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		movieService.delete(id);
		return "redirect:/admin/movie";
	}
}

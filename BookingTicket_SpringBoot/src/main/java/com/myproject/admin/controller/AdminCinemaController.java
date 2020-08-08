package com.myproject.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Null;

import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Cinema;
import com.myproject.service.CinemaService;
import com.myproject.service.CineplexService;

@Controller
@RequestMapping("admin/cinema")
public class AdminCinemaController {
	
	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	private CineplexService cineplexService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("cinemas", cinemaService.findAll());
		return "cinema/index";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("cinema", new Cinema());
		model.addAttribute("cineplexs", cineplexService.findAll());
		return "cinema/add";
	}
	
	@PostMapping("add")
	public String add(Model model, 
			@Validated @ModelAttribute("cinema") Cinema cinema,
			BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("cinema", cinema);
			model.addAttribute("cineplexs", cineplexService.findAll());
			return "cinema/add";
		}
		ResponseModel<Null> errorModel = cinemaService.insert(cinema);
		if(!errorModel.isStatus()) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("cinema", cinema);
			model.addAttribute("cineplexs", cineplexService.findAll());
			return "cinema/add";
		}
		
		return "redirect:/admin/cinema";
		
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("cinema", cinemaService.findById(id));
		model.addAttribute("cineplexs", cineplexService.findAll());
		return "cinema/edit";
	}
	
	@PostMapping("edit")
	public String edit(Model model, 
			@Validated @ModelAttribute("cinema") Cinema cinema,
			BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("cinema", cinema);
			model.addAttribute("cineplexs", cineplexService.findAll());
			return "cinema/edit";
		}
		ResponseModel<Null> errorModel = cinemaService.update(cinema);
		if(!errorModel.isStatus()) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("cineplexs", cineplexService.findAll());
			return "cinema/edit";
		}
		return "redirect:/admin/cinema";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		cinemaService.delete(id);
		return "redirect:/admin/cinema";
	}
}

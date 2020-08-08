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
import com.myproject.model.entity.Cineplex;
import com.myproject.service.CineplexService;

@Controller
@RequestMapping("admin/cineplex")
public class AdminCineplexController {
	
	@Autowired
	private CineplexService cineplexService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("cineplexs", cineplexService.findAll());
		return "cineplex/index";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("cineplex", new Cineplex());
		return "cineplex/add";
	}
	
	@PostMapping("add")
	public String add(Model model, 
			@Validated @ModelAttribute("cineplex") Cineplex cineplex,
			BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("cineplex", cineplex);
			return "cineplex/add";
		}
		ResponseModel<Null> errorModel = cineplexService.insert(cineplex);
		if(!errorModel.isStatus()) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("cineplex", cineplex);
			return "cineplex/add";
		}
		
		return "redirect:/admin/cineplex";
		
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("cineplex", cineplexService.findById(id));
		return "cineplex/edit";
	}
	
	@PostMapping("edit")
	public String edit(Model model, 
			@Validated @ModelAttribute("cineplex") Cineplex cineplex,
			BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("cineplex", cineplex);
			return "cineplex/edit";
		}
		ResponseModel<Null> errorModel = cineplexService.update(cineplex);
		if(!errorModel.isStatus()) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("cineplex", cineplex);
			return "cineplex/edit";
		}
		return "redirect:/admin/cineplex";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		cineplexService.delete(id);
		return "redirect:/admin/cineplex";
	}
}

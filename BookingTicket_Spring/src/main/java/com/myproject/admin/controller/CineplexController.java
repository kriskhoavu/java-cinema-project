package com.myproject.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.common.BaseResponse;
import com.myproject.entity.Cineplex;
import com.myproject.service.ICineplexService;

@Controller
@RequestMapping("admin/cineplex")
public class CineplexController {

	@Autowired
	private ICineplexService _cineplexService;

	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("cineplexes", _cineplexService.findAll());
		return "cineplex/index";
	}
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("cineplex", new Cineplex());
		return "cineplex/add";
	}

	@PostMapping("add")
	public String add(ModelMap model, @Validated @ModelAttribute("cineplex") Cineplex cineplex, BindingResult errors) {
		if (errors.hasErrors()) { // Should be error page
			return "cineplex/index";
		}

		BaseResponse baseResponse = _cineplexService.insert(cineplex);
		if (!baseResponse.isStatus()) {
			model.addAttribute("message", baseResponse.getMessage());
			model.addAttribute("cineplex", cineplex);
			return "cineplex/add";
		}

		return "redirect:/admin/cineplex";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("cineplex", _cineplexService.findById(id));
		return "cineplex/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, @Validated @ModelAttribute("cineplex") Cineplex cineplex, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("cineplex", cineplex);
			return "cineplex/edit";
		}
		BaseResponse baseResponse = _cineplexService.update(cineplex);
		if (!baseResponse.isStatus()) {
			model.addAttribute("message", baseResponse.getMessage());
			model.addAttribute("cineplex", cineplex);
			return "cineplex/edit";
		}
		return "redirect:/admin/cineplex";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		_cineplexService.delete(id);
		return "redirect:/admin/cineplex";
	}
}

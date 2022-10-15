package com.myproject.admin.controller;

import com.myproject.entity.Cineplex;
import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.service.CineplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

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
		model.addAttribute("uploadUrlAPI", CONSTANT.API_DMS_UPLOAD_FILE);
		return "cineplex/add";
	}

	@PostMapping("add")
	public String add(Model model, @Validated @ModelAttribute("cineplex") Cineplex cineplex, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("cineplex", cineplex);
			return "cineplex/add";
		}
		ResponseModel<Null> errorModel = cineplexService.insert(cineplex);
		if (errorModel.getStatusCode() != CONSTANT.API_RESPONSE_STATUS_CODE_OK) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("cineplex", cineplex);
			return "cineplex/add";
		}

		return "redirect:/admin/cineplex";

	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("cineplex", cineplexService.findById(id));
		model.addAttribute("uploadUrlAPI", CONSTANT.API_DMS_UPLOAD_FILE);
		return "cineplex/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, @Validated @ModelAttribute("cineplex") Cineplex cineplex, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("cineplex", cineplex);
			return "cineplex/edit";
		}
		ResponseModel<Null> errorModel = cineplexService.update(cineplex);
		if (errorModel.getStatusCode() != CONSTANT.API_RESPONSE_STATUS_CODE_OK) {
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

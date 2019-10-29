package com.myproject.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.entity.Role;
import com.myproject.repository.IRoleRepository;

@Controller
@RequestMapping("admin/role")
public class RoleController {

	@Autowired
	private IRoleRepository _rolIRoleRepository;

	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("roles", _rolIRoleRepository.findAll());
		return "cineplex/index";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("role", new Role());
		return "roleAdd";
	}

	@PostMapping("add")
	public String add(ModelMap model, @Validated @ModelAttribute("role") Role role, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("roles", _rolIRoleRepository.findAll());
			return "roleAdd";
		}
		if (_rolIRoleRepository.save(role) != null) {
			return "redirect:/admin/role";
		}

		return "roleList";
	}

}

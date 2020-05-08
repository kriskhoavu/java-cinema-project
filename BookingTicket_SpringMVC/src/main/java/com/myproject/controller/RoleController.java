package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.dto.RoleDto;
import com.myproject.entity.Role;
import com.myproject.services.impl.RoleService;

@Controller
@RequestMapping("admin/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("roles", roleService.findAll());
		
		return "roleList";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("role", new Role());
		return "roleAdd";
	}

	@PostMapping("add")
	public String add(ModelMap model, 
			@Validated @ModelAttribute("role") RoleDto role, 
			BindingResult errors) {
		// Nếu có lỗi
		if(errors.hasErrors()) {
			return "roleAdd";
		}
		roleService.save(role);
		return "redirect:/admin/role";
	}

	// Lấy thông tin role theo id
	@GetMapping("edit/{id}")
	public String edit(@PathVariable String id, ModelMap model) {
		RoleDto role = roleService.findById(id);
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("role", role);
		return "roleEdit";
	}

	@PostMapping("edit")
	public String edit(@ModelAttribute("role") RoleDto role) {
		roleService.update(role);
		return "redirect:/admin/role";
	}

	// Lấy thông tin role theo id
	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		roleService.delete(id);
		return "redirect:/admin/role";
	}
}

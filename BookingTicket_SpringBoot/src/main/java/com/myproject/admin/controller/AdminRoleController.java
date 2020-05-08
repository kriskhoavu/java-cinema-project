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
import com.myproject.common.BaseRequestResponse;
import com.myproject.dto.RoleDto;
import com.myproject.service.RoleService;

@Controller
@RequestMapping("admin/role")
public class AdminRoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "role/index";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("role", new RoleDto());
		return "role/add";
	}
	
	@PostMapping("add")
	public String add(Model model, 
			@Validated @ModelAttribute("role") RoleDto role,
			BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("role", role);
			return "role/add";
		}
		BaseRequestResponse<Null> errorModel = roleService.insert(role);
		if(!errorModel.isStatus()) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("role", role);
			return "role/add";
		}
		
		return "redirect:/admin/role";
		
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("role", roleService.findById(id));
		return "role/edit";
	}
	
	@PostMapping("edit")
	public String edit(Model model, 
			@Validated @ModelAttribute("role") RoleDto role,
			BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("role", role);
			return "role/edit";
		}
		BaseRequestResponse<Null> errorModel = roleService.update(role);
		if(!errorModel.isStatus()) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("role", role);
			return "role/edit";
		}
		return "redirect:/admin/role";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		roleService.delete(id);
		return "redirect:/admin/role";
	}
}

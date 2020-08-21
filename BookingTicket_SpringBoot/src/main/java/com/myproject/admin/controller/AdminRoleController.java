package com.myproject.admin.controller;

import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.dto.RoleDto;
import com.myproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

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
		ResponseModel<Null> errorModel = roleService.insert(role);
		if(errorModel.getStatusCode() != CONSTANT.API_RESPONSE_STATUS_CODE_OK) {
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
		ResponseModel<Null> errorModel = roleService.update(role);
		if(errorModel.getStatusCode() != CONSTANT.API_RESPONSE_STATUS_CODE_OK) {
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

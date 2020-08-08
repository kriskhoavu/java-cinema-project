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
import com.myproject.model.dto.RegisterDto;
import com.myproject.model.dto.UserDto;
import com.myproject.service.RoleService;
import com.myproject.service.UserService;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("users", userService.findAll());
		return "user/index";
	}

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("user", new RegisterDto());
		model.addAttribute("roles", roleService.findAll());
		return "user/add";
	}

	@PostMapping("add")
	public String add(Model model, @Validated @ModelAttribute("user") RegisterDto user, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("roles", roleService.findAll());
			return "user/add";
		}
		ResponseModel<Null> errorModel = userService.insert(user);
		if (!errorModel.isStatus()) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("user", user);
			model.addAttribute("roles", roleService.findAll());
			return "user/add";
		}

		return "redirect:/admin/user";

	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		UserDto userDto = userService.findById(id);
		model.addAttribute("user", userDto);
		model.addAttribute("roles", roleService.findAll());
		return "user/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, @Validated @ModelAttribute("user") UserDto user, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("roles", roleService.findAll());
			return "user/edit";
		}
		ResponseModel<Null> errorModel = userService.update(user);
		if (!errorModel.isStatus()) {
			model.addAttribute("message", errorModel.getMessage());
			model.addAttribute("user", user);
			model.addAttribute("roles", roleService.findAll());
			return "user/edit";
		}

		return "redirect:/admin/user";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		userService.delete(id);
		return "redirect:/admin/user";
	}
}

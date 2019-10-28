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

import com.myproject.dto.RegisterDto;
import com.myproject.dto.UserDto;
import com.myproject.services.IRoleService;
import com.myproject.services.IUserService;
import com.myproject.validation.UserValidator;

@Controller
@RequestMapping("admin/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("users", userService.findAll());
		return "userList";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("user", new RegisterDto());
		return "userAdd";
	}

	@PostMapping("add")
	public String add(ModelMap model, @Validated @ModelAttribute("user") RegisterDto user, BindingResult errors) {
		// Nếu có lỗi
		userValidator.validate(user, errors);
		if (errors.hasErrors()) {
			model.addAttribute("roles", roleService.findAll());
			return "userAdd";
		}
		if(userService.save(user));
		
		return "redirect:/admin/user";
	}

	// Lấy thông tin user theo id
	@GetMapping("edit/{id}")
	public String edit(@PathVariable String id, ModelMap model) {
		UserDto user = userService.findById(id);
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("user", user);
		return "userEdit";
	}

	@PostMapping("edit")
	public String edit(@ModelAttribute("user") UserDto user) {
		userService.update(user);
		return "redirect:/admin/user";
	}

	// Lấy thông tin user theo id
	@GetMapping("delete/{id}")
	public String delete(@PathVariable String id) {
		userService.delete(id);
		return "redirect:/admin/user";
	}
}

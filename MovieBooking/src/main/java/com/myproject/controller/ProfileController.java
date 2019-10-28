package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.dto.UserDto;
import com.myproject.services.IRoleService;
import com.myproject.services.IUserService;

@Controller
@RequestMapping("/user/profile")
public class ProfileController {

	@Autowired
	private IRoleService _roleService;

	@Autowired
	private IUserService _userService;

	@RequestMapping(value = "/role", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return _roleService.findAll();
	}

	@GetMapping("edit/{userId}")
	public String profile(@PathVariable String userId, ModelMap model) {
		model.addAttribute("roles", _roleService.findAll());
		model.addAttribute("user", _userService.findById(userId));
		return "userProfile";
	}

	@PostMapping("edit")
	public String edit(@ModelAttribute("user") UserDto user) {
		_userService.update(user);
		return "redirect:/user/profile/edit/" + user.getId();
	}
	
	@PostMapping("editPassword")
	public String editPassword(@ModelAttribute("user") UserDto user) {
		_userService.update(user);
		System.out.println(user.getId());
		return "redirect:/user/profile/edit/" + user.getId();
	}
	
	@GetMapping("course")
	public String course() {
		return "userCourse";
	}
}

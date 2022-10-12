package com.myproject.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("auth")
public class AdminLoginController {
	@GetMapping("login")
	public String login(@RequestParam(required = false) String error, Model model) {
		if (error != null && error.equals("true")) {
			model.addAttribute("message", "Wrong username or password.");
		}
		return "user/login";
	}
}

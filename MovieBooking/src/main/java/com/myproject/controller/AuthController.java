package com.myproject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.dto.RegisterDto;
import com.myproject.services.IUserService;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private IUserService _userService;

	@PostMapping("register")
	public Object register(@Validated @RequestBody RegisterDto user, BindingResult errors) {
		Map<String, String> map = new HashMap<String, String>();
		if (errors.hasErrors()) {
			map.put("success", "false");
			map.put("message", "Thông tin nhập chưa chính xác!");
		}

		_userService.save(user);
		map.put("success", "true");
		map.put("message", "Thêm mới thành công!");

		return "";
	}
}

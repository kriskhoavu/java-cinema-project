package com.myproject.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myproject.dto.RegisterDto;
import com.myproject.services.IUserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	public IUserService _userService;

	public boolean supports(Class<?> clazz) {
		return RegisterDto.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		RegisterDto user = (RegisterDto) target;

		// Kiểm tra confirm đã nhập chưa
		if (user.getConfirm() == null || user.getConfirm().length() == 0) {
			errors.rejectValue("confirm", "user", "Vui lòng nhập lại mật khẩu!");
		}
		// Kiểm tra password và confirm có trùng hay không
		else if (!user.getConfirm().equals(user.getPassword())) {
			errors.rejectValue("confirm", "user", "Mật khẩu không khớp!");
		} else if (_userService.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "user", "Email đã tồn tại!");
		}
	}

}

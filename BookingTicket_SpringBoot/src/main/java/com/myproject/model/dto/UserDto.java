package com.myproject.model.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("deprecation")
public class UserDto {
	
	private String id;
	
	@NotBlank(message = "Email chưa được nhập!")
	@Email(message = "Email không đúng định dạng!")
	private String email;
	
	@NotBlank(message = "Họ tên chưa được nhập!")
	private String fullname;
	
	private String avatar;
	private String phone;
	private String address;
	
	@NotBlank(message = "Vui lòng chọn loại người dùng!")
	private String roleId;
	
	private RoleDto role;
	
	public UserDto() {
	}

	public UserDto(String id, String email, String fullname, String avatar, String phone, String address,
			String roleId) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.avatar = avatar;
		this.phone = phone;
		this.address = address;
		this.roleId = roleId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}
}

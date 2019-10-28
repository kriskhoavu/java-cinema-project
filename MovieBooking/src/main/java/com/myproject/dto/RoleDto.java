package com.myproject.dto;

import javax.validation.constraints.NotBlank;

public class RoleDto {
	private String id;
	
	@NotBlank(message = "Tên quyền không được trống!")
	private String name;
	
	@NotBlank(message = "Mô tả không được trống!")
	private String description;
	
	public RoleDto() {}
	
	public RoleDto(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

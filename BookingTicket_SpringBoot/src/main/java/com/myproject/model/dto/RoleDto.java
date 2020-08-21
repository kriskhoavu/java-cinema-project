package com.myproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private String id;

    @NotBlank(message = "Role name is required.")
    private String name;

    @NotBlank(message = "Role description is required.")
    private String description;
}

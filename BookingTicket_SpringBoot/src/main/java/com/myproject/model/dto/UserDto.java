package com.myproject.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
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
}

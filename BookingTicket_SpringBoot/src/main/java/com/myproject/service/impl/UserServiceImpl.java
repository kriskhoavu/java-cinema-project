package com.myproject.service.impl;

import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.dto.RegisterDto;
import com.myproject.model.dto.RoleDto;
import com.myproject.model.dto.UserDto;
import com.myproject.model.entity.Role;
import com.myproject.model.entity.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        List<User> users = userRepository.findAll();
        for (User item : users) {
            UserDto userDto = new UserDto();
            userDto.setId(item.getId());
            userDto.setEmail(item.getEmail());
            userDto.setFullname(item.getFullname());
            userDto.setAvatar(item.getAvatar());
            userDto.setPhone(item.getPhone());
            userDto.setAddress(item.getAddress());
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public UserDto findById(String id) {
        UserDto userDto = new UserDto();
        User user = userRepository.findById(id).get();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFullname(user.getFullname());
        userDto.setAvatar(user.getAvatar());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setRoleId(user.getRoleId());

        Role role = user.getRole();
        userDto.setRole(new RoleDto(role.getId(), role.getName(), role.getDescription()));

        return userDto;
    }

    @Override
    public ResponseModel<Null> insert(RegisterDto model) {

        if (userRepository.findByEmail(model.getEmail()) != null) {
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_FAILED, "EMAIL ALREADY EXISTS");
        }
        try {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setEmail(model.getEmail());
            // Hash password
            user.setPassword(BCrypt.hashpw(model.getPassword(), BCrypt.gensalt(12)));
            user.setFullname(model.getFullname());
            user.setAvatar(model.getAvatar());
            user.setPhone(model.getPhone());
            user.setAddress(model.getAddress());
            user.setRoleId(model.getRoleId());

            userRepository.save(user);
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
        }
    }

    @Override
    public ResponseModel<Null> update(UserDto model) {
        try {
            User user = userRepository.findById(model.getId()).get();
            if (user == null) {
                return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
            }
            user.setEmail(model.getEmail());
            user.setFullname(model.getFullname());
            user.setAvatar(model.getAvatar());
            user.setPhone(model.getPhone());
            user.setAddress(model.getAddress());
            user.setRoleId(model.getRoleId());

            userRepository.save(user);
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
        }
    }

    @Override
    public ResponseModel<Null> delete(String id) {
        try {
            userRepository.deleteById(id);
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
        }
    }
}

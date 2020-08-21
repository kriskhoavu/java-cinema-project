package com.myproject.service.impl;

import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.dto.RoleDto;
import com.myproject.model.entity.Role;
import com.myproject.repository.RoleRepository;
import com.myproject.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = this.roleRepository.findAll();
        List<RoleDto> rolesDto = new ArrayList<RoleDto>();

        roles.forEach(role -> {
            rolesDto.add(toModel(role));
        });
        return rolesDto;
    }

    @Override
    public RoleDto findById(String id) {
        return roleRepository.findById(id).map(role -> toModel(role)).orElse(null);
    }

    @Override
    public ResponseModel<Null> insert(RoleDto model) {
        try {
            if (roleRepository.findByName(model.getName()) != null) {
                return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_FAILED, "ROLE ALREADY EXISTS");
            }

            Role role = new Role();
            role.setId(UUID.randomUUID().toString());
            role.setName(model.getName());
            role.setDescription(model.getDescription());

            roleRepository.save(role);
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
        }
    }

    @Override
    public ResponseModel<Null> update(RoleDto model) {
        try {
            Role role = roleRepository.findById(model.getId()).get();

            if (role == null) {
                return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
            }

            role.setId(UUID.randomUUID().toString());
            role.setName(model.getName());
            role.setDescription(model.getDescription());

            roleRepository.save(role);
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
        }
    }

    @Override
    public ResponseModel<Null> delete(String id) {
        try {
            roleRepository.deleteById(id);
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
        }
    }

    private RoleDto toModel(Role role) {
        RoleDto model = new RoleDto();
        BeanUtils.copyProperties(role, model);
        return model;
    }
}

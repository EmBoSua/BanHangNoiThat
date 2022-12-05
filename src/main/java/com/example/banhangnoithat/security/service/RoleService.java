package com.example.banhangnoithat.security.service;

import com.example.banhangnoithat.response.BHNTResponse;
import com.example.banhangnoithat.security.dto.RoleDto;
import com.example.banhangnoithat.security.dto.UserDto;

import java.util.List;

public interface RoleService {
    BHNTResponse<RoleDto> save(RoleDto dto);
    BHNTResponse<RoleDto> update(RoleDto dto);
    BHNTResponse<Boolean> delete(Long id);
    BHNTResponse<RoleDto> getUser(Long id);
    BHNTResponse<List<RoleDto>> getAll();
}

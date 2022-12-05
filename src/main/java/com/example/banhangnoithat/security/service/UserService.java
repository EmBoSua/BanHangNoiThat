package com.example.banhangnoithat.security.service;

import com.example.banhangnoithat.response.BHNTResponse;
import com.example.banhangnoithat.security.dto.UserDto;

import java.util.List;

public interface UserService {
    BHNTResponse<UserDto> save(UserDto dto);
    BHNTResponse<UserDto> addRoleToUser(String username, String roleName);
    BHNTResponse<UserDto> update(UserDto dto);
    BHNTResponse<Boolean> delete(Long id);
    BHNTResponse<UserDto> getUser(Long id);
    BHNTResponse<List<UserDto>> getAll();
}

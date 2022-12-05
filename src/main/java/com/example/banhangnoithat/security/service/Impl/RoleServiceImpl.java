package com.example.banhangnoithat.security.service.Impl;

import com.example.banhangnoithat.response.BHNTResponse;
import com.example.banhangnoithat.security.domain.Role;
import com.example.banhangnoithat.security.dto.RoleDto;
import com.example.banhangnoithat.security.repository.RoleRepository;
import com.example.banhangnoithat.security.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public BHNTResponse<RoleDto> save(RoleDto dto) {
        Role role = roleRepository.save(dto.toEntity());
        return new BHNTResponse<>(new RoleDto(role));
    }

    @Override
    public BHNTResponse<RoleDto> update(RoleDto dto) {
        return null;
    }

    @Override
    public BHNTResponse<Boolean> delete(Long id) {
        return null;
    }

    @Override
    public BHNTResponse<RoleDto> getUser(Long id) {
        return null;
    }

    @Override
    public BHNTResponse<List<RoleDto>> getAll() {
        return new BHNTResponse<>(roleRepository.findAll().stream().map(e -> new RoleDto(e)).collect(Collectors.toList()));
    }
}

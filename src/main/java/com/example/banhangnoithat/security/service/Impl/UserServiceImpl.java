package com.example.banhangnoithat.security.service.Impl;

import com.example.banhangnoithat.response.BHNTResponse;
import com.example.banhangnoithat.security.domain.Role;
import com.example.banhangnoithat.security.domain.User;
import com.example.banhangnoithat.security.dto.RoleDto;
import com.example.banhangnoithat.security.dto.UserDto;
import com.example.banhangnoithat.security.repository.RoleRepository;
import com.example.banhangnoithat.security.repository.UserRepository;
import com.example.banhangnoithat.security.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public BHNTResponse<UserDto> save(UserDto dto) {
        User user = dto.toEntity();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (!CollectionUtils.isEmpty(dto.getRoles())) {
            for (RoleDto element : dto.getRoles()) {
                user.getRoles().add(roleRepository.findByName(element.getName()));
            }
        }
        user = userRepository.save(user);
        return new BHNTResponse<>(new UserDto(user));
    }

    @Override
    public BHNTResponse<UserDto> addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        user = userRepository.save(user);
        return new BHNTResponse<>(new UserDto(user));
    }

    @Override
    public BHNTResponse<UserDto> update(UserDto dto) {
        return null;
    }

    @Override
    public BHNTResponse<Boolean> delete(Long id) {
        return null;
    }

    @Override
    public BHNTResponse<UserDto> getUser(Long id) {
        return null;
    }

    @Override
    public BHNTResponse<List<UserDto>> getAll() {
        List<UserDto> users = userRepository.findAll().stream().map(e -> new UserDto(e)).collect(Collectors.toList());

        return new BHNTResponse<>(users, users.size());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found in database");
        }

        return user;
    }
}

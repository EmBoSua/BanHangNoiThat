package com.example.banhangnoithat.security.dto;

import com.example.banhangnoithat.security.domain.Role;
import com.example.banhangnoithat.security.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Set<RoleDto> roles = new HashSet<>();
    private Boolean active;
    private String password;

    public UserDto(User entity){
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.email = entity.getEmail();
        if (!CollectionUtils.isEmpty(entity.getRoles())){
            this.roles.clear();
            Set<RoleDto> set = entity.getRoles().stream().map(e -> new RoleDto(e)).collect(Collectors.toSet());
            this.roles.addAll(set);
        }
    }

    public User toEntity(){
        User user = new User();
        user.setUsername(this.username);
        user.setEmail(this.email);
        user.setActive(this.active);
        user.setPassword(this.password);
//        if (!CollectionUtils.isEmpty(this.roles)){
//            Set<Role> set = this.roles.stream().map(e -> e.toEntity()).collect(Collectors.toSet());
//            user.setRoles(set);
//        }
        return user;
    }
}

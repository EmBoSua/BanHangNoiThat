package com.example.banhangnoithat.security.dto;

import com.example.banhangnoithat.security.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private String name;
    public RoleDto(Role entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Role toEntity(){
        Role role = new Role();
        role.setName(this.name);
        return role;
    }
}

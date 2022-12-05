package com.example.banhangnoithat.security.domain;

import com.example.banhangnoithat.security.auditing.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "tbl_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AuditableEntity implements GrantedAuthority {
    @Transient
    private static final long serialVersionUID = 6318192070978248463L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150, nullable = false, unique = true)
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}

package com.example.banhangnoithat.security.auditing;

import com.example.banhangnoithat.security.utils.SecurityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Objects;

public class AuditListenerEntity {
    @PostRemove
    public void remove(AuditableEntity auditableEntity) {
        LocalDateTime now = LocalDateTime.now();
        auditableEntity.setModifyDate(now);
        Object principal = SecurityUtils.getPrincipal();
        if (!Objects.isNull(principal)) {
            if (principal instanceof UserDetails) {
                UserDetails user = (UserDetails) principal;
                System.out.println("After Remove " + auditableEntity.toString() + " by" + user.getUsername());
            } else {
                System.out.println("After Remove " + auditableEntity.toString() + " by" + principal);
            }
        }
    }

    @PrePersist
    public void create(AuditableEntity auditableEntity) {
        LocalDateTime now = LocalDateTime.now();
        auditableEntity.setCreateDate(now);
        auditableEntity.setModifyDate(now);
        Object principal = SecurityUtils.getPrincipal();
        if (!Objects.isNull(principal)) {
            if (principal instanceof UserDetails) {
                UserDetails user = (UserDetails) principal;
                auditableEntity.setCreateBy(user.getUsername());
                auditableEntity.setModifyBy(user.getUsername());
            } else {
                auditableEntity.setCreateBy(principal.toString());
                auditableEntity.setModifyBy(principal.toString());
            }
        } else {
            auditableEntity.setCreateBy("admin");
        }
    }

    @PreUpdate
    public void update(AuditableEntity auditableEntity) {
        LocalDateTime now = LocalDateTime.now();
        auditableEntity.setModifyDate(now);
        Object principal = SecurityUtils.getPrincipal();
        if (!Objects.isNull(principal)) {
            if (principal instanceof UserDetails) {
                UserDetails user = (UserDetails) principal;
                auditableEntity.setModifyBy(user.getUsername());
            } else {
                auditableEntity.setModifyBy(principal.toString());
            }
        }
    }
}

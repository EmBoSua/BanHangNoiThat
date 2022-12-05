package com.example.banhangnoithat.security.auditing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners({AuditListenerEntity.class})
public class AuditableEntity implements Serializable {
    @Transient
    public static final long serialVersionUID = 4559994432567537044L;
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;
    @Column(name = "create_by", nullable = false, length = 100)
    private String createBy;
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;
    @Column(name = "modify_by", length = 100)
    private String modifyBy;
}

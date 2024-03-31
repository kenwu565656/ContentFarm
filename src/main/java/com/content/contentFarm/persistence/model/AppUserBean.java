package com.content.contentFarm.persistence.model;

import com.content.constant.AppUserStatus;
import com.content.contentFarm.persistence.converter.AppUserStatusConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "App_User")
@Entity
public class AppUserBean {
    @Id
    @Column
    private String id;

    @Column("username")
    private String username;

    @Column("email")
    private String email;

    @Convert(converter = AppUserStatusConverter.class)
    @Column("status")
    private AppUserStatus status;
}

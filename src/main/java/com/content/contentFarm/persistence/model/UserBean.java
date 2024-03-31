package com.content.contentFarm.persistence.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "User")
public class UserBean {
    @Id
    private String id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;
}

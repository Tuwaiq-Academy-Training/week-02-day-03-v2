package com.example.userdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor  @Data
@Entity
public class User {
    @NotNull(message = "Id can't be null")
    @Id
    private Integer id;
    @NotEmpty(message = "username can't be empty")
    @Column(columnDefinition = "varchar(20) unique not null")
    private String username;
    @NotEmpty(message = "password can't be empty")
    private String password;
    @NotEmpty(message = "role can't be empty")
    @Column(columnDefinition = "varchar(10) check ( role='ADMIN' or role='USER' )")
    private String role;
}

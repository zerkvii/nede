package com.zenith.nede.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
@Data
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "userCache")
public class user extends base{

    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "*Please provide your name")
    @Column(name = "username")
    private String username;

    @Length(min = 8, message = "*Your password must have at least 8 characters")
    @NotEmpty(message = "*Please provide your password")
    @Column(name = "password")
    private String password;
    public user(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }


}

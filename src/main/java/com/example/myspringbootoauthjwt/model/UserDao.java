package com.example.myspringbootoauthjwt.model;

import com.example.myspringbootoauthjwt.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class UserDao {

    private String username;
    private String password;
    private Collection<Role> roles;

}

package com.example.demo.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Alex Bukhmiller on 27.11.2017.
 */

public enum  Role implements GrantedAuthority {
    USER;


    @Override
    public String getAuthority() {
        return name();
    }


}


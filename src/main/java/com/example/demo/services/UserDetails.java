package com.example.demo.services;

import com.example.demo.database.entites.Account;
import com.example.demo.domain.Role;
import com.google.common.collect.ImmutableList;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 * Created by Alex Bukhmiller on 27.11.2017.
 */
@Service
public class UserDetails implements UserDetailsService {


    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return Account.builder()
                .username(username)
                .password("1234")
                .authorities(ImmutableList.of(Role.USER))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
    }
}

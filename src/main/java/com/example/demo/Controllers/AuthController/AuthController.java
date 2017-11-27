package com.example.demo.Controllers.AuthController;

import com.example.demo.database.entites.Account;
import com.example.demo.database.repository.RepositoryAccount;
import com.example.demo.domain.Role;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Alex Bukhmiller on 26.11.2017.
 */
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    RepositoryAccount account;

    @RequestMapping("/auth")
    @ResponseBody
    public Account getString() {
        Account a = account.save(new Account("admin", "pass", ImmutableList.of(Role.USER), true, true, true, true));
       Account acc = account.findByUsername("user");
        return acc;
    }
}

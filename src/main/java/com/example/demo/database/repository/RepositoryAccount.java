package com.example.demo.database.repository;

import com.example.demo.database.entites.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex Bukhmiller on 26.11.2017.
 */

@Repository
public interface RepositoryAccount extends CrudRepository<Account, Long> {
    Account findByUsername(String username);
}

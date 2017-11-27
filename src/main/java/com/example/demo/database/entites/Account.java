package com.example.demo.database.entites;

import com.example.demo.domain.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex Bukhmiller on 26.11.2017.
 */
@Entity
@Builder
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account implements UserDetails {


    public Account(String name, String pass, List<Role> auth, boolean nonExpired, boolean nonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.username = name;
        this.password = pass;
        this.authorities = auth;
        this.accountNonExpired = nonExpired;
        this.accountNonLocked = nonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    long id;

    @JsonProperty
    @Column(name = "name")
    String username;

    @JsonProperty
    @Column(name = "password")
    String password;

    @JsonProperty
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "auth", joinColumns = @JoinColumn(name = "name"))
    @Column(name = "auth")
    List<Role> authorities;

    @JsonProperty
    boolean accountNonExpired;

    @JsonProperty
    boolean accountNonLocked;

    @JsonProperty
    boolean credentialsNonExpired;

    @JsonProperty
    boolean enabled;


}

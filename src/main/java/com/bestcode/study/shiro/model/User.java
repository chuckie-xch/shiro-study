package com.bestcode.study.shiro.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xch
 * @create 2018-01-07 22:30
 **/
public class User {

    private String uid;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

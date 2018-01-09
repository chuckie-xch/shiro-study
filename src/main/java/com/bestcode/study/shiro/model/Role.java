package com.bestcode.study.shiro.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xch
 * @create 2018-01-07 22:29
 **/
public class Role {
    private Integer rid;
    private String name;
    private Set<Permission> permissions = new HashSet<>();
    private Set<User> users = new HashSet<>() ;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

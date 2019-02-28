package com.rakoi.webapp.classeye.classeye.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    public int id;
    public String username;
    public String password;
    @ManyToMany
    @JoinTable(name = "user_role",joinColumns =@JoinColumn(name ="user_id"),inverseJoinColumns=@JoinColumn(name = "role_id") )
    public Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

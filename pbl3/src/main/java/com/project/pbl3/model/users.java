package com.project.pbl3.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class users {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Boolean Enable;
    private Integer teacherId;

    @OneToMany(mappedBy = "users")
    Set<users_roles> users_roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Set<com.project.pbl3.model.users_roles> getUsers_roles() {
        return users_roles;
    }

    public void setUsers_roles(Set<com.project.pbl3.model.users_roles> users_roles) {
        this.users_roles = users_roles;
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

    public Boolean getEnable() {
        return Enable;
    }

    public void setEnable(Boolean enable) {
        Enable = enable;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}

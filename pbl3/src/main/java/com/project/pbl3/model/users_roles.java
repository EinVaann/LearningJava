package com.project.pbl3.model;

import javax.persistence.*;

@Entity
public class users_roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    users users;

    @ManyToOne
    @JoinColumn(name ="role_id")
    roles roles;

    public Integer getId() {
        return id;
    }

    public com.project.pbl3.model.users getUsers() {
        return users;
    }

    public void setUsers(com.project.pbl3.model.users users) {
        this.users = users;
    }

    public com.project.pbl3.model.roles getRoles() {
        return roles;
    }

    public void setRoles(com.project.pbl3.model.roles roles) {
        this.roles = roles;
    }
}

package com.project.pbl3.model;

import javax.persistence.*;

@Entity
@Table(name="users_roles")
public class User_Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    User User;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name ="role_id")
    Role Role;

    public Integer getId() {
        return id;
    }

    public User getUsers() {
        return User;
    }

    public void setUsers(User User) {
        this.User = User;
    }

    public Role getRoles() {
        return Role;
    }

    public void setRoles(Role Role) {
        this.Role = Role;
    }
}

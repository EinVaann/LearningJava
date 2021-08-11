package com.project.pbl3.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class roles {
    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "roles")
    Set<users_roles> users_roles;
}

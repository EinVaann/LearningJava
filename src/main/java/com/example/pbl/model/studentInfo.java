package com.example.pbl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class studentInfo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long ID;

    private String name;

    private String class1;

    private String phone;

    private String email;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass1() { return class1; }

    public void setClass1(String class1) { this.class1 = class1; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}

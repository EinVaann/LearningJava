package com.project.pbl3.service;

import com.project.pbl3.model.roles;
import com.project.pbl3.model.users;
import com.project.pbl3.model.users_roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserDetail implements UserDetails {


    private users user;

    public MyUserDetail(users users) {
        user = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<roles> role = new ArrayList<>();
        for(users_roles i : user.getUsers_roles()){
            role.add(i.getRoles());
        }
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for(roles r : role){
            authorityList.add(new SimpleGrantedAuthority(r.getName()));
        }
        return authorityList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getEnable();
    }
}

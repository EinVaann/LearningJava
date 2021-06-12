package com.project.pbl3.service;

import com.project.pbl3.model.roles;
import com.project.pbl3.model.users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUserDetail implements UserDetails {


    private users user;

    public MyUserDetail(users users) {
        user = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<roles> role = user.getRoles();
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

package com.project.pbl3.service;

import com.project.pbl3.model.Role;
import com.project.pbl3.model.User;
import com.project.pbl3.model.User_Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserDetail implements UserDetails {


    private User user;

    public MyUserDetail(User User) {
        user = User;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> role = new HashSet<>();
        System.out.println(user.getUsers_roles());
        for(User_Role i:user.getUsers_roles()){
            role.add(i.getRoles());
        }
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for(Role r : role){
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

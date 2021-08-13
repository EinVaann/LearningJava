package com.project.pbl3.service;


import com.project.pbl3.model.User;
import com.project.pbl3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Iterable<User> usersIterable = userRepository.findAll();
        for(User u: usersIterable){
            if(u.getUsername().compareTo(s)==0){
                return new MyUserDetail(u);
            }
        }
        throw new UsernameNotFoundException("Could not find User");
    }
}

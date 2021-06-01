package com.project.pbl3.service;


import com.project.pbl3.model.users;
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
        Iterable<users> usersIterable = userRepository.findAll();
        for(users u: usersIterable){
            //System.out.print(s+u.getUsername());
            //System.out.println(u.getUsername().compareTo(s));
            if(u.getUsername().compareTo(s)==0){

                //System.out.print("FOUND");
                return new MyUserDetail(u);
            }
        }
        //System.out.print("NOT FOUND");
        throw new UsernameNotFoundException("Could not find User");
    }
}

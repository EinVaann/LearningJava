package com.project.pbl3.controller;

import com.project.pbl3.model.Role;
import com.project.pbl3.model.User;
import com.project.pbl3.model.User_Role;
import com.project.pbl3.repositories.RoleRepository;
import com.project.pbl3.repositories.UserRepository;
import com.project.pbl3.repositories.UserRoleRepository;
import com.project.pbl3.service.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class userController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public String register(@ModelAttribute("users") User User){
        List<User> userList = userRepository.findAll();
        for(User u: userList){
            if(u.getUsername().compareTo(User.getUsername())==0)
                return "invalid";
        }
        if(User.getUsername()=="" || User.getPassword()==""){
            return "invalid";
        }

        User.setPassword(PasswordEncoder.getEncodePass(User.getPassword()));
        User.setEnable(true);
        User.setTeacherId(0);
        userRepository.save(User);
        User_Role User_Role = new User_Role();
        User_Role.setUsers(User);
        User_Role.setRoles(roleRepository.getOne(3));
        userRoleRepository.save(User_Role);
        return "/success";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/users-list")
    public String getUsersList(Model model){
        List<User> userList = userRepository.findAll();
        model.addAttribute("usersList", userList);
        List<User_Role> usersRolesList = userRoleRepository.findAll();
        model.addAttribute("userRoleList",usersRolesList);
        return "users";
    }

    @RequestMapping("/delete-user")
    public String deleteUser(@RequestParam int id){
        userRepository.deleteById(id);
        return "redirect:/users-list";
    }
}

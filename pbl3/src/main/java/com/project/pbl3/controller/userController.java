package com.project.pbl3.controller;

import com.project.pbl3.model.Role;
import com.project.pbl3.model.Teacher;
import com.project.pbl3.model.User;
import com.project.pbl3.model.User_Role;
import com.project.pbl3.repositories.RoleRepository;
import com.project.pbl3.repositories.TeacherRepository;
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
    @Autowired
    private TeacherRepository teacherRepository;

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

    @PostMapping("link-user")
    public String editUser(@ModelAttribute("users") User userInfo){
        userRepository.save(userInfo);
        return "redirect:/user";
    }
    @GetMapping("/link-user")
    public String linkUser (Model model,@RequestParam int id){
        User users = userRepository.getOne(id);
        model.addAttribute("userInfo",users);
        List<Teacher> teachersList1 = teacherRepository.findTeachersByNonUser();
        List<Role> rolesList = roleRepository.findAll();
        model.addAttribute("teachersList1",teachersList1);
        System.out.print(teachersList1.size());
        model.addAttribute("rolesList",rolesList);
        return "link-user";
    }
}

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
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        List<User_Role> user_roleList = userRoleRepository.findAll();
        for(User_Role u: user_roleList) {
            if(u.getUsers().getId()==userInfo.getId()){
                u.setRoles(roleRepository.getOne(2));
            }
        }
        userRepository.save(userInfo);
        return "redirect:/users-list";
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
    @RequestMapping("re-password")
    public String rePassword(@RequestParam int id)
    {
        List<User> users = userRepository.findAll();
        for (User s:users) {
            if(s.getId()==id) {
                s.setPassword(PasswordEncoder.getEncodePass("1234"));
                userRepository.save(s);
            }
        }
        return "redirect:/user-list";
    }

    @RequestMapping("/change-pass")
    public String chPassword(HttpServletRequest request){
        String token = request.getParameter("token");
        String newPass = request.getParameter("fname");
        User user = userRepository.findUserByToken(token);
        user.setPassword(PasswordEncoder.getEncodePass(newPass));
        user.setChangePasswordToken(null);
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping("/abort-change")
    public String abChange(Authentication authentication){
        String username = authentication.getName();
        User user = userRepository.findUserByName(username);
        user.setChangePasswordToken(null);
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping ("/change-pass")
    public String getChPassword(@RequestParam String token,Model model){
        model.addAttribute("token",token);
        return "/change-pass";
    }

    @GetMapping("/confirm-pass")
    public String confirmPassword(){
        return "/confirm-pass";
    }

    @PostMapping("/confirm-pass")
    public String confirmPassP(Authentication authentication, HttpServletRequest request){
        String username = authentication.getName();
        User user = userRepository.findUserByName(username);
        String oldPass = request.getParameter("fname");
        System.out.println("pass is:"+oldPass);
        if(PasswordEncoder.match(oldPass,user.getPassword())) {
            System.out.println("match");
            String changeToken = RandomString.make(45);
            user.setChangePasswordToken(changeToken);
            userRepository.save(user);
            return "redirect:/change-pass?token="+changeToken;
        }
        else return "invalid";
    }
}

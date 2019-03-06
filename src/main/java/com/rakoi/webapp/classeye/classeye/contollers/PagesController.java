package com.rakoi.webapp.classeye.classeye.contollers;

import com.rakoi.webapp.classeye.classeye.Entities.Role;
import com.rakoi.webapp.classeye.classeye.Entities.User;
import com.rakoi.webapp.classeye.classeye.repos.RoleRepository;
import com.rakoi.webapp.classeye.classeye.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PagesController {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/")
    public String home(ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        modelMap.addAttribute("username",authentication.getName());
        Role role=roleRepository.getOne(1);
        User user=userRepository.findByUsername(authentication.getName());

        boolean isAdmin=user.getRoles().contains(role);

        if (isAdmin){

            return "admin/addLecturer";
        }
        else {
            return "lecturer/index";
        }





    }
    @RequestMapping("/records")
    public String records(ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        modelMap.addAttribute("username",authentication.getName());

        return "lecturer/records";
    }



//    ADMIN FUNCTIONS

    @RequestMapping(value = "/admin")
    public String admin(ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        modelMap.addAttribute("username",authentication.getName());

        return "admin/addLecturer";
    }

    @RequestMapping(value = "/admin/addLecturer",method = RequestMethod.GET)
    public String addLec(ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        List<Role> roles=roleRepository.findAll();
        modelMap.addAttribute("username",authentication.getName());




        return "admin/addLecturer";
    }

    @RequestMapping(value = "/admin/addLecturer",method = RequestMethod.POST)
    public String addLec(ModelMap modelMap, @ModelAttribute("user")User user,@ModelAttribute("accountType")String accountType){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String roleName;
        modelMap.addAttribute("username",authentication.getName());

        //get user from url
        User saveUser=user;
        saveUser.setPassword(encoder.encode(user.getPassword()));
        //save user from url
        userRepository.save(saveUser);

        //get user role
        HashSet<Role> roles=new HashSet<>();

        if (accountType.equals("admin")){
            roles.add(roleRepository.getOne(1));
        }else {
            roles.add(roleRepository.getOne(2));
        }

        //find saved user
        User userWithRole=userRepository.findByUsername(user.getUsername());

        userWithRole.setRoles(roles);

        userRepository.save(userWithRole);

        modelMap.put("msg","Added Successfully");

        return "admin/addLecturer";
    }

    @RequestMapping(value = "/admin/assignUnits",method = RequestMethod.GET)
    public String addLec(String username, String password, ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        modelMap.addAttribute("username",authentication.getName());



        return "admin/assignLecturerUnits";
    }


}

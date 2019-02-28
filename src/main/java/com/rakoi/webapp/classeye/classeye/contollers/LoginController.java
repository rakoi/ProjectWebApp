package com.rakoi.webapp.classeye.classeye.contollers;

import com.rakoi.webapp.classeye.classeye.Services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {


    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    public SecurityService securityService;

    @RequestMapping(value = "login")
    public String Login(String error,ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        if (error!=null){
            modelMap.addAttribute("error","Wrong Credentials");
        }

        if(authentication.getPrincipal()=="anonymousUser"){
            return "login";
        }else {
            return "redirect:/";
        }

    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String Login(String username, String password, ModelMap modelMap){


        if(securityService.login(username,password)){

            return "index";

        }else {
            System.out.println("ERORR LOGING IN ");
            modelMap.addAttribute("error","Wrong Credentials");
            return "login";
        }

    }
}

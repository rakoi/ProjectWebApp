package com.rakoi.webapp.classeye.classeye.contollers;

import com.rakoi.webapp.classeye.classeye.Entities.Lesson;
import com.rakoi.webapp.classeye.classeye.Entities.Role;
import com.rakoi.webapp.classeye.classeye.Entities.User;
import com.rakoi.webapp.classeye.classeye.Services.LessonService;
import com.rakoi.webapp.classeye.classeye.repos.LessonRepository;
import com.rakoi.webapp.classeye.classeye.repos.RoleRepository;
import com.rakoi.webapp.classeye.classeye.repos.UserRepository;
import com.rakoi.webapp.classeye.classeye.utils.QRgeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PagesController {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    QRgeneratorUtil qRgeneratorUtil;

    @Autowired
    LessonService lessonService;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    LessonRepository lessonRepository;

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
            Lesson currentLesson=lessonService.getCurrentLesson();
            if(currentLesson!=null){
                User lessonLec=lessonService.getCurrentLesson().getUsers();
                if(lessonLec!=user||lessonLec==null){

                    Lesson lesson=new Lesson();
                    modelMap.put("lesson",lesson);
                }else{
                     modelMap.put("lesson",currentLesson);
                }
            }





            modelMap.put("username",user.getUsername());

            try {
                if (currentLesson!=null){
                    modelMap.put("imageUrl",qRgeneratorUtil.generateQrCodeImage(currentLesson.getName()));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            modelMap.put("lessons",user.getLessons());
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

        modelMap.put("msg ","Added Successfully");

        return "admin/addLecturer";
    }

    @RequestMapping(value = "/admin/assignUnits",method = RequestMethod.GET)
    public String addLec(String username, String password, ModelMap modelMap){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        modelMap.addAttribute("username",authentication.getName());



        return "admin/assignLecturerUnits";
    }


    @RequestMapping(value = "/admin/addLecturerUnits",method = RequestMethod.POST)
    public String addLecUnits(ModelMap modelMap,@ModelAttribute("username")String username,@ModelAttribute("unit1")String unit1,@ModelAttribute("unit2")String unit2,@ModelAttribute("unit3")String unit3){

        User user=userRepository.findByUsername(username);
        Lesson unit_1=lessonRepository.findLessonsByName(unit1);
        Lesson unit_2=lessonRepository.findLessonsByName(unit2);
        Lesson unit_3=lessonRepository.findLessonsByName(unit3);

        unit_1.setUsers(user);
        unit_2.setUsers(user);
        unit_3.setUsers(user);


        lessonRepository.save(unit_1);
        lessonRepository.save(unit_2);
        lessonRepository.save(unit_2);

        modelMap.addAttribute("msg","Lessons assigned succesfully");


        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();


        modelMap.addAttribute("username",authentication.getName());


        return "admin/assignLecturerUnits";
    }


}

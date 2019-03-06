package com.rakoi.webapp.classeye.classeye;

import com.rakoi.webapp.classeye.classeye.Entities.*;
import com.rakoi.webapp.classeye.classeye.repos.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClasseyeApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LessonRepository lessonRepository;



    @Autowired
    AttendanceRepository attendanceRepository;

    @Test
    public void  addStudent(){
        Student student=new Student("JKC/D01/0210/2014","Brian","Rakoi");
       // studentRepository.save(student);

    }

    @Test
    public void addAttendance(){
        Lesson lesson=lessonRepository.getOne(1);
        Student student=studentRepository.getOne(1);
        Time time=new Time(System.currentTimeMillis());
        Attendance attendance=new Attendance(time,student,lesson);

      //  attendanceRepository.save(attendance);

    }

    @Test
    public void addLesson(){
        User user=userRepository.getOne(2);
        Time time=new Time(System.currentTimeMillis());
        Lesson lesson=new Lesson("OOP",time,user);

       // lessonRepository.save(lesson);
    }
    @Test
    public void getLessonLecturer(){
        Lesson lesson=lessonRepository.getOne(1);
        System.out.println(lesson.getUsers().getUsername());
    }
    @Test
    public void getRoles(){
        List Roles=roleRepository.findAll();
        System.out.println(Roles);
    }
    @Test
    public void contextLoads() {
    }

    @Test
    public void addUser(){
//          User user=new User("Brian","secret");
//        HashSet<Role> roles=new HashSet<>();
//        roles.add(roleRepository.getOne(1));
//        userRepository.save(user);
//        User savedUser=userRepository.findByUsername(user.getUsername());
//        savedUser.setUsername("MOJOJOJO");
//
//        savedUser.setRoles(roles);
//        System.out.println(savedUser.getId());
//
//        userRepository.save(savedUser);
    }

}

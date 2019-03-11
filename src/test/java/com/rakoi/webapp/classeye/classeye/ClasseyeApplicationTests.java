package com.rakoi.webapp.classeye.classeye;

import com.rakoi.webapp.classeye.classeye.Entities.*;
import com.rakoi.webapp.classeye.classeye.Services.LessonService;
import com.rakoi.webapp.classeye.classeye.repos.*;
import com.rakoi.webapp.classeye.classeye.utils.QRgeneratorUtil;
import com.rakoi.webapp.classeye.classeye.utils.myTimeUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClasseyeApplicationTests {

    @Autowired
    BCryptPasswordEncoder encoder;


    @Autowired
    UserRepository userRepository;

    @Autowired
    QRgeneratorUtil qRgeneratorUtil;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    LessonService lessonService;



    @Autowired
    AttendanceRepository attendanceRepository;

    @Test
    public void  addStudent(){
        Student student=new Student("JKC/D01/0211/2015","Brian","Rakoi");
        student.setPassword(encoder.encode(student.getAdmnumber()));
        studentRepository.save(student);

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
    public void getSingleLesson(){
        User user=userRepository.getOne(14);

        Lesson lesson=lessonRepository.getOne(1);
        List<Attendance> attendanceList=attendanceRepository.findByLesson(lesson);

        HashMap<Student,Integer> studentIntegerHashMap=new HashMap<>();

        for (Attendance at :attendanceList){
            if (studentIntegerHashMap.containsKey(at.getStudent())){
                studentIntegerHashMap.computeIfPresent(at.getStudent(),(k,v)->v+1);
            }else{
                studentIntegerHashMap.put(at.student,0);
            }
        }

        for(Student student:studentIntegerHashMap.keySet()){
            System.out.println(student.getFirstname()+studentIntegerHashMap.get(student));
        }
    }

    @Test
    public void contextLoads() {
    }


    @Test
    public void getRecords() {

        Student student = studentRepository.getOne(1);
        List<Lesson> lessons = lessonRepository.findAll();
        List<Attendance> attendanceList=attendanceRepository.findAll();


        HashMap<Lesson,Integer> attendanceHashMap=new HashMap<>();



       for (Lesson lesson:lessons){
         attendanceHashMap.put(lesson,0);
           if (attendanceHashMap.containsKey(lesson)){
               attendanceHashMap.computeIfPresent(lesson,(k,v)->v+attendanceRepository.findAttendanceByLessonAndAndStudent(lesson,student).size());
           }
       }

    }

}

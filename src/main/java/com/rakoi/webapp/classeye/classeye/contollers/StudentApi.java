package com.rakoi.webapp.classeye.classeye.contollers;

import com.rakoi.webapp.classeye.classeye.Entities.Attendance;
import com.rakoi.webapp.classeye.classeye.Entities.Lesson;
import com.rakoi.webapp.classeye.classeye.Entities.Student;
import com.rakoi.webapp.classeye.classeye.Services.LessonService;
import com.rakoi.webapp.classeye.classeye.repos.AttendanceRepository;
import com.rakoi.webapp.classeye.classeye.repos.LessonRepository;
import com.rakoi.webapp.classeye.classeye.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentApi {

    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    public BCryptPasswordEncoder encoder;

    @Autowired
    public LessonService lessonService;

    @Autowired
    public LessonRepository lessonRepository;

    @Autowired
    public AttendanceRepository attendanceRepository;

    @PostMapping("login")
    public Student login(@RequestBody Student student){
        Student getstudent=studentRepository.findStudentByAdmnumber(student.getAdmnumber());
        if (getstudent.getPassword().equals(encoder.encode(student.getPassword()))){
            return getstudent;
        }else{
            return new Student();
        }

    }
    @GetMapping("getlesson")
    public Lesson getCurrentLesson(){
        return lessonService.getCurrentLesson();
    }

    @GetMapping("**")
    public Student getStudent(HttpServletRequest request){

        String requesturl=request.getRequestURL().toString();
        String admno=requesturl.replace("http://localhost:8090/api/student/","");
        return studentRepository.findStudentByAdmnumber(admno);
    }

    @GetMapping({"{StudentId}/{UnitCode}"})
    public Attendance checkIn(@PathVariable("StudentId")String StudentId,@PathVariable("UnitCode")String UnitCode){

        Lesson lesson=lessonRepository.findLessonsByUnitcode(UnitCode);
        Student student=studentRepository.getOne(Integer.parseInt(StudentId));

        Time time=new Time(System.currentTimeMillis());
        Attendance attendance=new Attendance(time,student,lesson);

        attendanceRepository.save(attendance);
        return attendance;
    }

    @GetMapping("getAttendace/{studentId}")
    public HashMap<String, Integer> getAttendance(@PathVariable("studentId")int studentId){

        Student student = studentRepository.getOne(studentId);
        List<Lesson> lessons = lessonRepository.findAll();
        List<Attendance> attendanceList=attendanceRepository.findAll();


        System.out.println(studentId);
        HashMap<String,Integer> attendanceHashMap=new HashMap<>();



        for (Lesson lesson:lessons){
            attendanceHashMap.put(lesson.getName(),0);
            if (attendanceHashMap.containsKey(lesson.getName())){
                attendanceHashMap.computeIfPresent(lesson.getName(),(k,v)->v+attendanceRepository.findAttendanceByLessonAndAndStudent(lesson,student).size());
            }
        }
        return attendanceHashMap;
    }
}

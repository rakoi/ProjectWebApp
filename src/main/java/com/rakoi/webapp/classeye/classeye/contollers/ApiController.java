package com.rakoi.webapp.classeye.classeye.contollers;

import com.rakoi.webapp.classeye.classeye.Entities.Lesson;
import com.rakoi.webapp.classeye.classeye.Entities.User;
import com.rakoi.webapp.classeye.classeye.repos.LessonRepository;
import com.rakoi.webapp.classeye.classeye.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ApiController {

    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("lessons/{lessonName}")
    @CrossOrigin
    public List<Lesson> getLesson(@PathVariable("lessonName")String lessonName){
        return lessonRepository.findLessonsByNameContaining(lessonName);
    }



    @GetMapping("lecturer/{lecturerName}")
    @CrossOrigin
    public List<User> getLec(@PathVariable("lecturerName") String lecturerName){
        return userRepository.findUserByUsernameContaining(lecturerName);
    }
}

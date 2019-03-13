package com.rakoi.webapp.classeye.classeye.Services;

import com.rakoi.webapp.classeye.classeye.Entities.Lesson;
import com.rakoi.webapp.classeye.classeye.repos.LessonRepository;
import com.rakoi.webapp.classeye.classeye.utils.myTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

@Service
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;


    public Lesson getCurrentLesson(){
        LocalDate date=LocalDate.now();
        DayOfWeek dow=date.getDayOfWeek();
        String day=dow.toString();

        Time ltime= Time.valueOf(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));

        myTimeUtils timeUtils=new myTimeUtils();
        Time startTime=timeUtils.getPastTimeinHours(ltime,1);
        Time endTime=timeUtils.getFutureTimeinHours(ltime,2);

        Lesson lesson= lessonRepository.findCurrentLesson(day,startTime,endTime);

        return lesson;
    }


}


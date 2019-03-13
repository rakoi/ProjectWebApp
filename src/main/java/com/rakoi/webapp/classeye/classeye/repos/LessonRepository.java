package com.rakoi.webapp.classeye.classeye.repos;

import com.rakoi.webapp.classeye.classeye.Entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {


    List<Lesson> findLessonsByNameContaining(String lessonName);
    Lesson findLessonsByName(String name);


//    @Query(value =
//            "SELECT l FROM Lesson l WHERE day=:day and ltime BETWEEN :ltime and :endtime ")
//        Lesson findCurrentLesson(String day,Time ltime,Time endtime);



    @Query(value =
            "SELECT l FROM Lesson l WHERE day=:day and ltime between :ltime and :endtime ")
        Lesson findCurrentLesson(String day,Time ltime,Time endtime);




}

package com.rakoi.webapp.classeye.classeye.repos;

import com.rakoi.webapp.classeye.classeye.Entities.Lesson;
import com.rakoi.webapp.classeye.classeye.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {


    List<Lesson> findLessonsByNameContaining(String lessonName);
    Lesson findLessonsByName(String name);

    List<Lesson> findLessonsByUsers(User user);

    @Query(value =
            "SELECT l FROM Lesson l WHERE day=:day and ltime between :ltime and :endtime ")
        Lesson findCurrentLesson(String day,Time ltime,Time endtime);




}

package com.rakoi.webapp.classeye.classeye.repos;

import com.rakoi.webapp.classeye.classeye.Entities.Attendance;
import com.rakoi.webapp.classeye.classeye.Entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {


    List<Attendance> findByLesson(Lesson lesson);
}

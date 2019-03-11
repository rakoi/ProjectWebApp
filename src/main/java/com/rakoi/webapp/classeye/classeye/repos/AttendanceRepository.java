package com.rakoi.webapp.classeye.classeye.repos;

import com.rakoi.webapp.classeye.classeye.Entities.Attendance;
import com.rakoi.webapp.classeye.classeye.Entities.Lesson;
import com.rakoi.webapp.classeye.classeye.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {


    List<Attendance> findByLesson(Lesson lesson);

    List<Attendance> findAttendanceByLessonAndAndStudent(Lesson lesson,Student student);


}

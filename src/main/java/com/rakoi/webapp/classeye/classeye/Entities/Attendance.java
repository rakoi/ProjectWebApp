package com.rakoi.webapp.classeye.classeye.Entities;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    public int id;
    @Column(name = "ltime")
    public Time time;

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student student;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    public Lesson lesson;

    public Attendance(Time time, Student student, Lesson lesson) {
        this.time = time;
        this.student = student;
        this.lesson = lesson;
    }

    public Attendance() {
    }



    public int getId() {
        return id;
    }

    public Time getTime() {
        return time;
    }

    public Student getStudent() {
        return student;
    }
}

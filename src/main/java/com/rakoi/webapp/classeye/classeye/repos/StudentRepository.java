package com.rakoi.webapp.classeye.classeye.repos;

import com.rakoi.webapp.classeye.classeye.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentByAdmnumber(String admNo);

}

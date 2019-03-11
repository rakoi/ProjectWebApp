package com.rakoi.webapp.classeye.classeye.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="student")
public class Student{


    @Id
    public int id;
    public String admnumber;
    public String firstname;
    public String lastname;
    public String password;


    public Student(String admnumber, String firstname, String lastname) {
        this.admnumber = admnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password=admnumber;
    }

    public Student(String admnumber, String password) {
        this.admnumber = admnumber;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdmnumber(String admnumber) {
        this.admnumber = admnumber;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAttendance(Set<Attendance> attendance) {
        this.attendance = attendance;
    }

    @JsonIgnore
    @OneToMany(mappedBy="student")
    public Set<Attendance> attendance=new HashSet<>();



    public Student() {
    }


    public int getId() {
        return id;
    }

    public String getAdmnumber() {
        return admnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Set<Attendance> getAttendance() {
        return attendance;
    }
}

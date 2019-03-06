package com.rakoi.webapp.classeye.classeye.Entities;

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

    @OneToMany(mappedBy="student")
    public Set<Attendance> attendance=new HashSet<>();



    public Student() {
    }

    public Student(String admnumber, String firstname, String lastname) {
        this.admnumber = admnumber;
        this.firstname = firstname;
        this.lastname = lastname;
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

package com.rakoi.webapp.classeye.classeye.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lesson")
public class Lesson {

    @Id
    public int id;
    public String name;
    public Time ltime;
    public String day;
    public String unitcode;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    public User users;
    @OneToMany(mappedBy ="lesson")
    @JsonIgnore
    public Set<Attendance> attendance=new HashSet<>();

    public Set<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(Set<Attendance> attendance) {
        this.attendance = attendance;
    }

    public Lesson() {
        this.name="No Active Lesson";
        this.unitcode="----";
    }

    public Lesson(String name, Time ltime, User users) {
        this.name = name;
        this.ltime = ltime;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getLtime() {
        return ltime;
    }

    public void setLtime(Time ltime) {
        this.ltime = ltime;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


}

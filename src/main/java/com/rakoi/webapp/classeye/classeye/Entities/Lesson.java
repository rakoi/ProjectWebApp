package com.rakoi.webapp.classeye.classeye.Entities;

import javax.management.timer.Timer;
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

    @ManyToOne
    @JoinColumn(name="user_id")
    public User users;

    @OneToMany(mappedBy ="lesson")
    public Set<Attendance> attendance=new HashSet<>();

    public Lesson() {
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
}

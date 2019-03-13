package com.rakoi.webapp.classeye.classeye.utils;

import java.sql.Time;

public class myTimeUtils {

    public Time getFutureTimeinHours(Time time,int hours){

        return new Time(time.getHours()+hours,time.getMinutes(),time.getSeconds());
    }
    public Time getPastTimeinHours(Time time,int hours){

        return new Time(time.getHours()-hours,time.getMinutes(),time.getSeconds());
    }
}

package com.ssh;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @Author lt
 * @create 2018-04-02 14:22
 * @VERSION 1.0
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        System.out.println(simpleDateFormat.format(time));
    }

}

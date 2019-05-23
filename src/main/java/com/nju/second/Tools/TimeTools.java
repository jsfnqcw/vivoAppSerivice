package com.nju.second.Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTools {
    public static String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public static boolean ifMorethanXsecond(String timeInput,int X){
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date input = simpleFormat.parse(timeInput);
            long t1 = input.getTime();
            long t2 = new Date().getTime();
            long seconds = (t2-t1)/1000;
            return seconds>X;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean ifNowInTimeSection(String sectionStart,String sectionEnd){
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            long Start = simpleFormat.parse(sectionStart).getTime();
            long End = simpleFormat.parse(sectionEnd).getTime();
            long t = new Date().getTime();

            return (Start<=t) && (t<=End);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getMonthGap(String dateInput){
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date input = simpleFormat.parse(dateInput);
            Date now = new Date();
            return (now.getYear()-input.getYear())*12+(now.getMonth()-input.getMonth());
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

}

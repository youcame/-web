package com.neu.edu.utils;

import java.text.SimpleDateFormat;

public final class MyDate {
    public final static String getDate() {
        java.util.Date now = new java.util.Date();
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String time = df.format(now);
        return time;
    }
}

package com.gqgx.common.lang;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hunter on 2020-06-23.
 */
public class Dates {

    private static SimpleDateFormat sdf = new SimpleDateFormat();


    public static String format(String pattern, Date date) {
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    public static void main(String[] args) {
        Date date = new Date();
        String format = Dates.format("yyyy-MM-dd HH:mm:ss", date);
        System.out.println(format);
    }
}

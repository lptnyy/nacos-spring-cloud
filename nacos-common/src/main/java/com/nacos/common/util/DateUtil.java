package com.nacos.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getyyMMddHHmmss(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    public static Date getyyMMddHHmmss(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

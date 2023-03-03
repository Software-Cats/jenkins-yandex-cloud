package org.jenkins.plugins.yc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static long dateStrToLong(String dateStr) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        long lDate = 0;
        try {
            Date date = df.parse(dateStr);
            lDate = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lDate;
    }
}

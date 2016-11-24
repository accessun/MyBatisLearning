package io.github.accessun.utils;

import java.util.Calendar;
import java.util.Date;

public class MyDateTimeUtils {
    
    public static int yearsFrom(Date date) {
        Calendar thisCal = Calendar.getInstance();
        thisCal.setTime(new Date());
        int thisYear = thisCal.get(Calendar.YEAR);
        
        Calendar thatCal = Calendar.getInstance();
        thatCal.setTime(date);
        int thatYear = thatCal.get(Calendar.YEAR);
        
        return thisYear - thatYear;
    }
    
    private MyDateTimeUtils() {
    }

}

package com.gzhipin.utils;

import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    private DateUtils(){}

    @NonNull
    public static Date now() {return new Date();}

    @NonNull
    public static Calendar convertTo(@NonNull Date date){
        Assert.notNull(date, "Date must not be null");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date add (@NonNull Date date, long time, @NonNull TimeUnit timeUnit) {
        Assert.notNull(date, "Date must not be null");
        Assert.isTrue(time > 0, "Addition time must not be less than 1");
        Assert.notNull(timeUnit, "Time unit must not be null");

        Date result;

        int timeIntValue;

        if (time > Integer.MAX_VALUE) {
            timeIntValue = Integer.MAX_VALUE;
        }else{
            timeIntValue = Long.valueOf(time).intValue();
        }

        switch (timeUnit) {
            case DAYS:
                result = org.apache.commons.lang3.time.DateUtils.addDays(date, timeIntValue);
                break;
            case HOURS:
                result = org.apache.commons.lang3.time.DateUtils.addHours(date, timeIntValue);
                break;
            case MINUTES:
                result = org.apache.commons.lang3.time.DateUtils.addMinutes(date, timeIntValue);
                break;
            case SECONDS:
                result = org.apache.commons.lang3.time.DateUtils.addSeconds(date, timeIntValue);
                break;
            case MILLISECONDS:
                result = org.apache.commons.lang3.time.DateUtils.addMilliseconds(date, timeIntValue);
                break;

            default:
                result = date;
        }

        return result;
    }
}

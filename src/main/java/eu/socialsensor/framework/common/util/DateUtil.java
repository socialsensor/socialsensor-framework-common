package eu.socialsensor.framework.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Class for handling date util
 * @author ailiakop
 *
 */
public class DateUtil {
    public Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //negative number decrements the days
        return cal.getTime();
    }
}
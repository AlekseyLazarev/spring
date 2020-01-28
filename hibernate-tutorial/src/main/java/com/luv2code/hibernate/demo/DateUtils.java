package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class DateUtils
 * <p>
 * Date: 23.01.2020
 *
 * @author a.lazarev
 */
public class DateUtils {

    // The date formatter
    // - dd:   day in month (number)
    // - MM:   month in year (number)
    // - yyyy: year
    //
    // See this link for details: https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
    //
    //
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    // read a date string and parse/convert to a date
    public static Date parseDate(String dateStr) throws ParseException {
        return formatter.parse(dateStr);
    }

    // read a date and format/convert to a string
    public static String formatDate(Date theDate) {
        return theDate != null ? formatter.format(theDate): null;
    }
}

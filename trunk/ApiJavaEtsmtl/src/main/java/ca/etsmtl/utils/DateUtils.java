package ca.etsmtl.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zennad.nassima
 */
public class DateUtils {
    /*
     * formater une date de type string suivant un pattern donnée
     */

    static public String formateStringToDateString(String dateString, String pattern) {


        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern, Locale.FRENCH);
            Date date = df.parse(dateString);
            dateString = df.format(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }


        return dateString;

    }

    static public Date formateStringToDate(String dateString, String pattern) {


        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern, Locale.FRENCH);
            Date date = df.parse(dateString);
            return date;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }




    }

    static public int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.DATE);

    }

    static public int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.MONTH);

    }

    static public int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.get(Calendar.YEAR);

    }

    static public String convertDateToString(Date date) {
        StringBuffer sb = new StringBuffer();
        sb.append(getYear(date));
        sb.append("/");
        NumberFormat nf = new DecimalFormat("00");
        sb.append(nf.format(getMonth(date) + 1));
        sb.append("/");
        sb.append(getDay(date));
        return sb.toString();


    }

    static public String convertDateToStringPattern(Date date) {
//        StringBuffer sb = new StringBuffer();
//        sb.append(getYear(date));
//        sb.append("/");
//        NumberFormat nf = new DecimalFormat("00");
//        sb.append(nf.format(getMonth(date) + 1));
//        sb.append("/");
//        sb.append(getDay(date));
//        return sb.toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date dateTemp = new Date();
        dateTemp = date;
        return dateFormat.format(dateTemp);


    }

    static public String convertDateToStringPattern(Date date, String pattern) {
//        StringBuffer sb = new StringBuffer();
//        sb.append(getYear(date));
//        sb.append("/");
//        NumberFormat nf = new DecimalFormat("00");
//        sb.append(nf.format(getMonth(date) + 1));
//        sb.append("/");
//        sb.append(getDay(date));
//        return sb.toString();
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date dateTemp = new Date();
        dateTemp = date;
        return dateFormat.format(dateTemp);


    }

    public static String getFormatedCurrentDate() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();

        return convertDateToString(date);
    }

    public static Timestamp getCurrentTimeStamp() {
        java.util.Date date = new java.util.Date();
        return new Timestamp(date.getTime());
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static Date getCurrentDate_FormatDate() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateS = dateFormat.format(date);
        try {
            date = dateFormat.parse(dateS);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;

    }

    public static Date getTodayDate() {
        Calendar c = GregorianCalendar.getInstance();
        c.clear(Calendar.HOUR_OF_DAY);
        c.clear(Calendar.MINUTE);
        c.clear(Calendar.SECOND);
        c.clear(Calendar.MILLISECOND);
        Date today = c.getTime();
        return today;
    }
}

package org.javautil.buckets;



import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
// TODO lots of ancient cruft here
public class DateHelper {
    private int year;
    private int month;
    private int day;
    static final long ONE_HOUR = 60 * 60 * 1000L; // number of milliseconds in an hour
    private String sYear = null;
    private String sMonth = null;
    private String sDay = null;

    private java.util.Date date = null;

    private String errorMessage = null;

    boolean valid = true;

    /**
     Construct a date from a string.
     */
    /*
    public DateHelper(String dt) {
        int monthEnds = 0;
        int dayEnds = 0;

        try {
            monthEnds = dt.indexOf("/");
            sMonth = dt.substring(0,monthEnds);
        } catch (Exception e) {
            valid  = false;
            errorMessage = "Improperly formatted date, does not contain '/'";
        }

        if (valid) {
            try {
                month = Integer.parseInt(sMonth);
            } catch (Exception e) {
                valid  = false;
                errorMessage  = "Improperly formatted date, month " + sMonth + " not a number";
            }
        }

        if (valid) {
            try {
                dayEnds = dt.indexOf("/",monthEnds + 1);
                sDay = dt.substring(monthEnds + 1,dayEnds);
            } catch (Exception e) {
                valid  = false;
                errorMessage = "Improperly formatted date, does not contain two  '/'";
            }
        }


        if (valid) {
            try {
                day = Integer.parseInt(sDay);
            } catch (Exception e) {
                valid  = false;
                errorMessage  = "Improperly formatted date, day " + sDay + " not a number";
            }
        }

        if (valid) {
            try {
                sYear = dt.substring(dayEnds + 1);
                year = Integer.parseInt(sYear);
            } catch (Exception e) {
                valid  = false;
                errorMessage = "Improperly formatted date, does not contain year";
            }
        }

        if (valid) {
            try {
                date = new java.util.Date(year - 1900, month - 1, day);
            } catch (Exception e) {
                valid = false;
                errorMessage = "Unable to construct date " + day + "/" + month + "/" + year;
            }
        }
    }
    */

    public java.util.Date getDate() {
        return date;
    }


    @Deprecated
    public static String getDateFormatted(java.util.Date dt) {
        return getDateFormattedYyyyMmDd(dt);
    }

    @Deprecated
    public static String getDateFormattedYyyyMmDd(java.util.Date dt) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfMonth = cal.get(Calendar.DATE);
        StringBuffer buff = new StringBuffer(16);
        if (dt != null) {
            buff.append(year);
            buff.append("/");
            if (month <= 9) {
                buff.append("0");
            }
            buff.append(month);
            buff.append("/");
            if (dayOfMonth < 10) {
                buff.append("0");
            }
            buff.append(dayOfMonth);
        }
        return new String(buff);
    }

    @Deprecated
    public static String toYyMmDd(java.sql.Timestamp dt) {
        return getDateFormattedYyMmDd(dt);
    }

    @Deprecated
    public static String toYyMmDd(java.sql.Date dt) {
        return getDateFormattedYyMmDd(dt);
    }

    @Deprecated
    public static String toYyMmDd(java.util.Date dt) {
        return getDateFormattedYyMmDd(dt);
    }

    // TODO what the hell is this?
    @Deprecated
    public static String getDateFormattedYyMmDd(java.util.Date dt) {
    	if (dt == null) {
    		throw new IllegalArgumentException("dt is null");
    	}
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        int year = cal.get(Calendar.YEAR) % 100;
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfMonth = cal.get(Calendar.DATE);
        StringBuffer buff = new StringBuffer(16);
        if (dt != null) {
            if (year <= 9) {
                buff.append("0");
            }
            buff.append(year);
            buff.append("/");
            if (month <= 9) {
                buff.append("0");
            }
            buff.append(month);
            buff.append("/");
            if (dayOfMonth < 10) {
                buff.append("0");
            }
            buff.append(dayOfMonth);
        }
        return new String(buff);
    }

    @Deprecated
    public static String toMmDdYy(java.util.Date dt) {
        if (dt == null) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        int year = cal.get(Calendar.YEAR) % 100;
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfMonth = cal.get(Calendar.DATE);
        StringBuffer buff = new StringBuffer(16);

            if (month <= 9) {
                buff.append("0");
            }
            buff.append(month);
            buff.append("/");
            if (dayOfMonth < 10) {
                buff.append("0");
            }
            buff.append(dayOfMonth);
            buff.append("/");
            if (year <= 9) {
                buff.append("0");
            }
            buff.append(year);

        return new String(buff);
    }

    /*
    public static String getDateFormatted(java.sql.Date dt) {
        String rc = "";
        if (dt != null) {
            rc =  (dt.getMonth() + 1) +  "/" + dt.getDate() + "/" + (dt.getYear() + 1900);
        }
        return rc;
    }
    */

    /*
    public java.sql.Date getSqlDate() {
        java.sql.Date rc = null;
        if (date != null) {
            rc = new java.sql.Date(date.getYear(),date.getMonth(),date.getDate());
        }
        return rc;
    }
    */

    public String getMessage() {
        return errorMessage;
    }


    /**
     * Removes the time component from a date, making the time midnight.
     *
     * @return Input argument with hours, minutes, seconds, and milliseconds set to zero.
     */
    public static java.util.Date getDateMidnight(java.util.Date dt) {
        Date rc = null;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        rc = cal.getTime();
        //System.out.println("midnight " + dt + " is " + rc);
        return rc;

    }

    /**
     * Removes the time component from a date, making the time midnight.
     *
     */
    public static java.util.Date getDateMidnight() {
        return getDateMidnight(new java.util.Date());
    }

    /**
     * Calculate the number of days between two dates.
     *
     * any time of day date2 any time of day date 1.
     * if date2 is after date1 the return is a postive number.
     *
     *
     *
     * @param date1  The first date
     * @param date2  The second date
     * @return The number of days between date1 and date2.
     *         If date1 is before date2 the result will be a positive integer.
     *         If date1 is after date2 the result will be a negative integer.
     */
    public static int daysBetween(java.util.Date date1, java.util.Date date2) {

        int differenceInDays;
        boolean swapSign = false;
        java.util.Date date1Midnight = getDateMidnight(date1);
        java.util.Date date2Midnight = getDateMidnight(date2);

        java.util.Date earlierDate;
        java.util.Date laterDate;
        java.util.Date tst1 = null;
        java.util.Date tst2 = null;

        if (date1.before(date2)) {
            earlierDate = date1Midnight;
            laterDate = date2Midnight;
        } else {
            earlierDate = date2Midnight;
            laterDate = date1Midnight;
            swapSign = true;
        }

        GregorianCalendar cal = new GregorianCalendar();
        long t1 = earlierDate.getTime();
        long t2 = laterDate.getTime();
        long diff = t2 - t1;
        // Add one hour in case the duration includes an unbalanced 23 hour Daylight Savings spring forward day.
        differenceInDays = (int) ((diff + ONE_HOUR) / (ONE_HOUR * 24));
        if (swapSign) {
            differenceInDays *= -1;
        }


        //assert addDays(date1Midnight,differenceInDays).equals(date2Midnight);

        // assert that we did this correctly
        cal.setTime(date1Midnight);
        tst1 = cal.getTime();
        cal.add(cal.DATE, differenceInDays);
        tst2 = cal.getTime();
        if (!tst2.equals(date2Midnight)) {
            System.out.println("tst2 " + tst2.getTime() + " d " + date2Midnight.getTime());
            throw new java.lang.IllegalStateException("Failure " + "  " + "\n" +
                    " date1 : " + date1 + " " + date1.getTime() + "\n" +
                    " date2 : " + date2 + " " + date2.getTime() + "\n" +
                    " t1 : " + t1 + " " + "\n" +
                    " t2 : " + t2 + " " + "\n" +
                    " earlierDate: " + earlierDate + earlierDate.getTime() + "\n" +
                    " laterDate: " + laterDate + laterDate.getTime() + "\n" +
                    " diff: " + diff + "\n" +
                    " differenceInDays " + differenceInDays + "\n" +
                    " tst1: " + tst1 + " " + tst1.getTime() + "\n" +
                    " tst2 : " + tst2 + " " + tst2.getTime() + "\n" +
                    " date2midnight: " + date2Midnight + " " + date2Midnight.getTime());
        }

        return differenceInDays;

    }

    /**
     * Return midnight for the first day of the month.
     *
     * @param dt
     * @return  midnight for the first day of the month.
     */

    public static java.util.Date getFirstDateInMonth(java.util.Date dt) {
        Date rc = null;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        rc = cal.getTime();
        return rc;
    }


    /**
     Returns a sql.Date without any time component.
     */
    public static java.sql.Date toSqlDate(java.util.Date dt) {
        java.sql.Date rc = null;
        if (dt != null) {
            rc = new java.sql.Date(getDateMidnight(dt).getTime());
        }
        return rc;
    }

    public static java.sql.Timestamp toSqlTimestamp(java.util.Date dt) {
        java.sql.Timestamp rc = null;
        if (dt != null) {
            rc = new java.sql.Timestamp(dt.getTime());
        }
        return rc;
    }

    static public java.util.Date addDays(java.util.Date startDate, int days) {

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(startDate);
        cal.add(cal.DATE, days);
        return cal.getTime();
    }

    static public java.util.Date addSeconds(java.util.Date startDate, int seconds) {

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(startDate);
        cal.add(cal.SECOND, seconds);
        return cal.getTime();
    }


    public static java.util.Date toDate(String dt) {
        String sYear = null;
        String sMonth = null;
        String sDay = null;
        int year;
        int month;
        int day;
        int monthEnds = 0;
        int dayEnds = 0;
        java.util.Date rc = null;
        try {
            monthEnds = dt.indexOf("/");
            sMonth = dt.substring(0, monthEnds);
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException("Improperly formatted date, does not contain '/'");
        }

        try {
            month = Integer.parseInt(sMonth);
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException("Improperly formatted date, month " + sMonth + " not a number");
        }

        try {
            dayEnds = dt.indexOf("/", monthEnds + 1);
            sDay = dt.substring(monthEnds + 1, dayEnds);
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException("Improperly formatted date, does not contain two  '/'");
        }

        try {
            day = Integer.parseInt(sDay);
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException("Improperly formatted date, day " + sDay + " not a number");
        }

        try {
            sYear = dt.substring(dayEnds + 1);
            year = Integer.parseInt(sYear);
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException("Improperly formatted date, does not contain year");
        }

        try {
            GregorianCalendar cal = new GregorianCalendar();
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month);
            cal.set(Calendar.DATE, day);
            long ms = cal.get(Calendar.MILLISECOND);
            rc = new java.util.Date(ms);
        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException("Unable to construct date " + day + "/" + month + "/" + year);
        }
        return rc;
    }

    /**

     Please note that the 4th of October, 1582 is directly followed by the 15th of October 1582 as decreed by Pope Gregor.
     (Pope Gregor forced this in order to achieve better agreement between the civil and the astronomical calendar)
     */
    public static double julianDayNumber(java.util.Date dt) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        int year = cal.get(Calendar.YEAR) + 1900;
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfMonth = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        //

        int leapCenturyDays;
        int regularLeapDays;
        double julianDay;
        double c1;

        if (month <= 2) {
            year--;
            month += 12;
        } else {
            month++;
        }

        // account for leap days using century
        // Pope Gregor's decree
        if (
                (year > 1582) ||
                (year == 1582 && month > 10) ||
                (year == 1582 && month == 10 && dayOfMonth >= 15)
        ) {
            leapCenturyDays = 2 - (year / 100) + (year / 400);
        } else {
            leapCenturyDays = 0;
        }


        // add in regular leap days
        if (year < 0) {
            regularLeapDays = (int) ((365.25 * year) - 0.75);
        } else {
            regularLeapDays = (int) (365.25 * year);
        }

        int D = (int) (30.6001 * (month + 1));

        double jdd =
                leapCenturyDays +
                regularLeapDays +
                D +
                dayOfMonth +
                hour / 24 +
                minutes / (24 * 60) +
                seconds / (24 * 60 * 60) +
                1720994.5;


        return jdd;
    }





    /**
     * Calculate calendar date for Julian date field this.jd
     */
    /*
    java.util.Date julianToDate(int julianDayNumber) {

        double jd2=julianDayNumber+0.5;
        long I= (long) jd2;
        // fractional day
        double F=jd2-I;
        long A=0;
        long B=0;

        if (I>2299160) {
             A =(long) ((double)I-1867216.25)/36524.25;
            double a3=(double)A/4.0;
            B=I+1+A-a3.longValue();
        } else {
            B=I;
        }

        double C=(double)B+1524;
        double d1=((C-122.1)/365.25);
        long D=d1;
        double e1=(365.25*(double)D);
        long E=e1;
        double g1=((double)(C-E)/30.6001);
        long G=g1;
        double h=((double)G*30.6001);
        long da=(long)C-E-h.longValue();
        date=new Integer((int)da);

        if (G<14L) {
            month=new Integer((int)(G-2L));
        } else {
            month=new Integer((int)(G-14L));
        }

        if (month.intValue()>1) {
            year=new Integer((int)(D-4716L));
        } else {
            year=new Integer((int)(D-4715L));
        }

        // Calculate fractional part as hours, minutes, and seconds
        double dhr=(24.0*F);
        hour=new Integer(dhr.intValue());
        double dmin=(dhr.doubleValue()-(double)dhr.longValue())*60.0;
        minute=new Integer(dmin.intValue());
        double dsec=(dmin()-(double)dmin.longValue())*60.0;
        second=new Integer(dsec.intValue());

    }
    */
    private static void lpad_0_2(StringBuffer sb, int x) {
        if (x < 10) {
            sb.append('0');
        }
        sb.append(x);
    }

    /**
     Time in IS0 8601 format.
     <br>
     e.g. 2002-11-29t11:29:00
     */
    public static String toISO8601(long millis) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date(millis));
        //int year = cal.get(Calendar.YEAR) + 1900 ;
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfMonth = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        StringBuffer buff = new StringBuffer();


        buff.append(year);
        buff.append('-');
        lpad_0_2(buff, month);
        buff.append('-');
        lpad_0_2(buff, dayOfMonth);
        buff.append('T');
        lpad_0_2(buff, hour);
        buff.append(':');
        lpad_0_2(buff, minutes);
        buff.append(':');
        lpad_0_2(buff, seconds);
        return new String(buff);
    }

    public static String toISO8601(Date date) {
        return toISO8601(date.getTime());
    }


    public static void main(String args[]) {
        int daysBetween;
        GregorianCalendar cal = new GregorianCalendar();
        java.util.Date today = new java.util.Date();
        System.out.println("today is " + today);
        cal.setTime(today);

        double jd = julianDayNumber(today);
        System.out.println("jdn " + jd);
        java.util.Date firstDay = DateHelper.getFirstDateInMonth(today);
        System.out.println("today " + today + " firstDay " + firstDay);
    }
}

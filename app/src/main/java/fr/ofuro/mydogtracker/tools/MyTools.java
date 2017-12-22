package fr.ofuro.mydogtracker.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ofuro on 18/10/2017.
 */

public class MyTools {

    public static String convertDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy", Locale.ENGLISH);
        String strDate;
        strDate = dateFormat.format(date);
        return strDate;
    }

    public static Date convertStringToDate (String string) {
        //SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        SimpleDateFormat inputFormatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = inputFormatter.parse(string);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

}

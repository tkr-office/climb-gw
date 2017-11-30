package jp.co.is.gw.rating.engine.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	private static final String PATTERN = "yyyy/MM/dd";

	public static Calendar stringDateToCalendar(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		sdf.parse(date);
		return sdf.getCalendar();
	}

	public static String calendarToString(Calendar calendar) {
	    return new SimpleDateFormat("yyyy/MM/dd").format(calendar.getTime());
	}

	public static Calendar addYesrs(Calendar calendar, int years) {

		calendar.add(Calendar.YEAR, years);
		return calendar;
	}

	public static Calendar addMonths(Calendar calendar, int months) {

		calendar.add(Calendar.MONTH, months);
		return calendar;
	}
}

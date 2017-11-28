package jp.co.is.gw.rating.engine.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	private static final String PATTERN = "yyyy/MM/dd";

	public static Calendar stringDateToCalendar(String date) {
		return new SimpleDateFormat(PATTERN).getCalendar();
	}

	public static Calendar addYesr(Calendar calendar, int years) {

		calendar.add(Calendar.YEAR, years);
		return calendar;
	}

	public static Calendar addDays(Calendar calendar, int days) {

		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar;
	}
}

package jp.co.is.gw.rating.engine.util;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Calendar;

import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStringDateToCalendar() throws Exception {

	Calendar actual = DateUtil.stringDateToCalendar("2017/11/01");

	assertThat(actual.getTime().toString(), is("Wed Nov 01 00:00:00 JST 2017"));
    }

    @Test
    public void testCalendarToString() throws Exception {

	String actual = DateUtil.calendarToString(DateUtil.stringDateToCalendar("2017/11/01"));

	assertThat(actual, is("2017/11/01"));
    }

    @Test
    public void testAddYears() throws Exception {

	Calendar actual = DateUtil.addYesrs(DateUtil.stringDateToCalendar("2017/11/01"), 1);

	assertThat(actual.getTime().toString(), is("Thu Nov 01 00:00:00 JST 2018"));
    }

    @Test
    public void testAddMonths() throws Exception {

	Calendar actual = DateUtil.addMonths(DateUtil.stringDateToCalendar("2017/11/01"), 2);

	assertThat(actual.getTime().toString(), is("Mon Jan 01 00:00:00 JST 2018"));
    }
}

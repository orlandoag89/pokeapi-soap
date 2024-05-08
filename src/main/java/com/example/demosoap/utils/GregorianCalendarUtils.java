package com.example.demosoap.utils;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public class GregorianCalendarUtils {
	
	public static Date getTime(final XMLGregorianCalendar gregorianCalendar) {
		return gregorianCalendar.toGregorianCalendar().getTime();
	}

}

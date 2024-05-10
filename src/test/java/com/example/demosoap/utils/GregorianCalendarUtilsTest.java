package com.example.demosoap.utils;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demosoap.mocks.Mocks;

@ExtendWith(MockitoExtension.class)
public class GregorianCalendarUtilsTest {
	
	Mocks mocks;
	
	@BeforeEach
	void before() {
		mocks = Mocks.getInstance();
	}

	@Test
	void getTimeTest() {
		final Date date = GregorianCalendarUtils.getTime(mocks.getGregorianCalendar());
		
		Assert.assertNotNull(date);
	}
}

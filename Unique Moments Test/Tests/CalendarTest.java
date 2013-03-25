package com.example.uniquemoments;

import java.sql.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalendarTest extends TestCase implements I_Calendar 
{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestShowCalendar() {
		boolean a=false;
		a=showCalendar();   //Asserts whether Calendar Shows up when called
		//a=true;
		assertTrue(a);
	}

	@Override
	public boolean showCalendar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEvent(event myEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEvent(event myEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editEvent(event myEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public event[] getDailyEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public event[] fetchEvents(Date myDate) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.example.uniquemoments;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.database.Cursor;
import com.example.uniquemoments.DatabaseController;

import android.app.Activity;


public class searchContactDBTest extends Activity {
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() 
	{
		String actual = "" ;
		String expected = "Antonia";
		DatabaseController DB = new DatabaseController(this);
		Cursor cur = DB.searchContactByName("Antonia");
		actual = cur.getString(cur.getColumnIndex("ContactsName"));

		assertEquals(actual, expected);
	}

}

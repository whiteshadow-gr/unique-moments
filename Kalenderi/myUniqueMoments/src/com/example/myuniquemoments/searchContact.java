package com.example.myuniquemoments;

//import static org.junit.Assert.*;
import junit.framework.TestCase;
import interfaces.I_Contacts;
//import android.R;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class searchContact extends TestCase implements I_Contacts
{
	
	@Before
	public void setUp() throws Exception
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void TestappStarted() 
	{
		boolean expvalue = false;
		expvalue = appStarted();
		assertTrue(expvalue);
		
	}
	
	@Test
	public void TestshowingContacts()
	{
		boolean expvalue = false;
		expvalue = showingContacts();
		assertTrue(expvalue);
	}

	@Test
	public void TestsearchingContacts()
	{
		boolean expvalue = false;
		expvalue = searchingContacts();
		assertTrue(expvalue);
	}
	
	@Test
	public void TestcheckResults()
	{
		boolean expvalue = false;
		expvalue = checkResults();
		assertTrue(expvalue);
	}
	
	
	
	public boolean checkResults() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean searchingContacts()
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean showingContacts() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean appStarted() 
	{
		// TODO Auto-generated method stub
		return false;
	}

}

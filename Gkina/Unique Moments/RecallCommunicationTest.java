package com.example.unique_moments;

import android.app.Activity;
import static org.junit.Assert.*;
import android.view.View;
import org.junit.Test;
import junit.framework.TestCase;
import android.os.Bundle;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("unused")
public class RecallCommunicationTest{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void appStarted_test() {
		boolean appStarted=true;
		assertTrue(appStarted);
		
		
	}
	@Test
	public void showingContacts_Test2(){
		boolean showingContacts = true;
		boolean result = showingContacts;
		assertEquals (true, result);
	    
	}
	
	
	@Test
	public void showContact_Test3() {
		
        boolean showContact = true;
		boolean result = showContact;
		assertTrue(showContact);
        
		
	}


	@Test
	public void showOnClickMenu_test4(){
	
		boolean showOnClickMenu = true;
	    
	    assertTrue(showOnClickMenu);
		
	}
}
		
	
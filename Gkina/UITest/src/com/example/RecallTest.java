package com;

import com.android.uiautomator.core.UiObject;


import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class RecallTest  extends UiAutomatorTestCase {

	protected  void setUp() throws Exception {
				super.setUp();
	}

	protected void tearDownA() throws Exception {
				super.tearDown();
	}

	public void testUniqueMomentExists() throws UiObjectNotFoundException {
	
		
	getUiDevice().pressEnter();	
	getUiDevice().pressEnter();	
	getUiDevice().pressBack();	
	getUiDevice().pressHome();
		
	 UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
	 allAppsButton.clickAndWaitForNewWindow();
	 
	 UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
	appsTab.click();
		
	 UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
	 appViews.setAsHorizontalList();
	 
	 UiObject UniqueMoments = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
	 UniqueMoments.clickAndWaitForNewWindow();
     
     UiObject UniqueMomentsValidation = new UiObject(new UiSelector().packageName("com.example.myuniquemoments"));
     assertTrue("Unable to detect UM",UniqueMomentsValidation.exists());
		
	}
 
	public void testContactExists() throws UiObjectNotFoundException {
		
		UiObject Contacts = new UiObject(new UiSelector().text("Contacts"));
		Contacts.click();
		
		UiObject ContactsValidation = new UiObject(new UiSelector().text("Contacts").className("android.widget.TextView"));
		assertTrue("Unable to detect the Contacts",ContactsValidation.exists());

		
	} 
	public void testShowContact() throws UiObjectNotFoundException {
		
		UiObject Contacts = new UiObject(new UiSelector().text("Contacts"));
		Contacts.click();
		
		UiObject ContactsValidation = new UiObject(new UiSelector().text("Contacts").className("android.widget.TextView"));
		assertTrue("Unable to detect the Contacts",ContactsValidation.exists());

		
	}
	
	
	
	
	
	

   /* public void testshowOnClickMenuEnter() throws UiObjectNotFoundException { 
		
    	getUiDevice().pressEnter();
    	
    
    	
		UiObject showOnClickMenuValidation = new UiObject(new UiSelector().text("showOnClickMenu").className("android.widget.TextView"));
		assertTrue("Unable to detect the showOnClickMenu",showOnClickMenuValidation.exists());
	}*/
	
	
	
	public void testSMSExists() throws UiObjectNotFoundException
	
	{
		getUiDevice().pressEnter();
	
		UiObject SMSValidation = new UiObject(new UiSelector().text("SMS").className("android.widget.ListView"));
		assertTrue("Unable to detect the SMS",SMSValidation.exists());
		
	}
    
    
    
    
    
    public void testShowLastSMSEnter() throws UiObjectNotFoundException {
		
	  
	    getUiDevice().pressEnter();
	 
		
		UiObject ShowLastSMSValidation = new UiObject(new UiSelector().text("ShowLastSMS").className("android.widget.TextView"));
		assertTrue("Unable to detect the ShowLastSMS",ShowLastSMSValidation.exists());
	
	
	
	}
    
    
public void testCallExists() throws UiObjectNotFoundException
	
	{
		getUiDevice().pressEnter();
	
		UiObject CallValidation = new UiObject(new UiSelector().text("Call").className("android.widget.ListView"));
		assertTrue("Unable to detect the Call",CallValidation.exists());
		
	}
    
    
    
    
    public void testShowLastCallEnter() throws UiObjectNotFoundException {
		
		
	    getUiDevice().pressEnter();
		
		
		UiObject ShowLastCallValidation = new UiObject(new UiSelector().text("ShowLastCall").className("android.widget.TextView"));
		assertTrue("Unable to detect the ShowLastCall",ShowLastCallValidation.exists());
	}
    
public void testEmailExists() throws UiObjectNotFoundException
	
	{
		getUiDevice().pressEnter();
	
		UiObject EmailValidation = new UiObject(new UiSelector().text("Email").className("android.widget.ListView"));
		assertTrue("Unable to detect the Email",EmailValidation.exists());
		
	}
    
    
    
	
	public void testShowLastEmailEnter() throws UiObjectNotFoundException {
		
		
		    getUiDevice().pressEnter();
		
			
			UiObject ShowLastEmailValidation = new UiObject(new UiSelector().text("ShowLastEmail").className("android.widget.TextView"));
			assertTrue("Unable to detect the ShowLastEmail",ShowLastEmailValidation.exists());
	}
	
	
	
	/*public void testshowOnClickMenuBack() throws UiObjectNotFoundException { 
		
	getUiDevice().pressBack();	
	
	UiObject BackfromshowOnClickMenuValidation = new UiObject(new UiSelector().text("Welcome to your Unique Moments!"));
	assertTrue(BackfromshowOnClickMenuValidation.exists());
 
	}*/



	
	
	
	

	
	
	
	
	
}


/**************************
 *  @author Foulidis Giannis
 *  Test Case: Add Event
 *  
 */
package com;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


@SuppressWarnings("unused")
public class AddEventTest extends UiAutomatorTestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	
	 //dokimazoume an iparxei i efarmogi
	
	
	
	
	
	//dokimazoume an trexei to activity gia tin eisagogi event
	
	@SuppressWarnings("deprecation")
	
	public void testaUMExists() throws UiObjectNotFoundException


	{
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
	   
		allAppsButton.clickAndWaitForNewWindow();
		
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
	    appsTab.click();
	    UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
	    appViews.setAsHorizontalList();
	    UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
	    UniqueMommentsApp.clickAndWaitForNewWindow();
	    UiObject UMValidation = new UiObject(new UiSelector().packageName("gr.um.uniquemoments"));
	    assertTrue("Unable to run Unique Moments",UMValidation.exists());
		
		
		
		
		
	}
	
	
	
	
	public void testbRunAddEventActivity() throws UiObjectNotFoundException

	{
		
		
	    
	    UiObject ManageEventsBtn = new UiObject(new UiSelector().text("Manage Events"));
	    ManageEventsBtn.clickAndWaitForNewWindow();
	    assertTrue( getUiDevice().getCurrentActivityName().equals("ActivityManageEvents"));
	    
	    
		
		
		
	}
	
public void testcNameFormat() throws UiObjectNotFoundException
	
	{
		
		
        UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
        editBox.setText("Genethlia");
        UiObject button = new UiObject (new UiSelector().text("Create Event"));
        button.clickAndWaitForNewWindow();
        fail();
        
		
	}

public void testdType() throws UiObjectNotFoundException

{
	

    UiObject txt = new UiObject(new UiSelector().index(4));
    txt.setText("#$@##");
    UiObject button = new UiObject (new UiSelector().text("Create Event"));
    button.clickAndWaitForNewWindow();
    fail();
    
   
	
}
	
public void testeDateFormat() throws UiObjectNotFoundException
	
	{
		
	
        UiObject txt = new UiObject(new UiSelector().index(6));
        txt.setText("!!!!!!!");
       
        UiObject button = new UiObject (new UiSelector().text("Create Event"));
        button.clickAndWaitForNewWindow();
        fail();
     
		
	}
	

	



public void testfDescFormat() throws UiObjectNotFoundException

{
	

    UiObject txt = new UiObject(new UiSelector().index(8));
    txt.setText("#$@##");
   
    
    UiObject button = new UiObject (new UiSelector().text("Create Event"));
    button.clickAndWaitForNewWindow();
    fail();
 
	
    
 
	
}

public void testgFieldsEmpty() throws UiObjectNotFoundException

{
	UiObject fieldName = new  UiObject(new UiSelector().index(2));
	UiObject fieldType = new  UiObject(new UiSelector().index(4));
	UiObject fieldDate = new  UiObject(new UiSelector().index(6));
	UiObject fieldDesc = new  UiObject(new UiSelector().index(8));
	
	
	 UiObject button = new UiObject (new UiSelector().text("Create Event"));
	    button.clickAndWaitForNewWindow();
	    fail();
	
}

public void testhCreateEvent() throws UiObjectNotFoundException

{
	 UiObject CreateEventsBtn = new UiObject(new UiSelector().text("Create Event"));
	  
	 
	/* if (!CreateEventsBtn.click())
	 {
		 fail(); //kapio provlima
	 }
	 */
	
}

public void testiHomeFromEvents() throws UiObjectNotFoundException
{
	
    
    getUiDevice().pressHome();      
    
    UiObject HomefromEventsValidation = new UiObject(new UiSelector().packageName("com.android.launcher"));
    assertTrue(HomefromEventsValidation.exists());
}

public void testjHomeFromCalendar() throws UiObjectNotFoundException
{
	
	getUiDevice().pressHome();
	UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
   
	allAppsButton.clickAndWaitForNewWindow();
	
	UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
    appsTab.click();
    UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
    appViews.setAsHorizontalList();
    UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
    UniqueMommentsApp.clickAndWaitForNewWindow();
    getUiDevice().pressBack(); //back from events
	UiObject Calendar = new UiObject(new UiSelector().text("Calendar"));
    Calendar.click();
    
    getUiDevice().pressHome();      
    
    UiObject HomefromCalendarValidation = new UiObject(new UiSelector().packageName("com.android.launcher"));
    assertTrue(HomefromCalendarValidation.exists());
    
   
}

		
	

}

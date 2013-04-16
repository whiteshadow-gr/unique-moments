package com;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;



public class CalendarNamedaysTest extends UiAutomatorTestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testaUniqueMomentExists() throws UiObjectNotFoundException {
	
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
	public void testbCalendarExists() throws UiObjectNotFoundException { 
		
		UiObject Calendar = new UiObject(new UiSelector().text("Calendar"));
		Calendar.click();
		
		UiObject CalendarValidation = new UiObject(new UiSelector().text("Calendar").className("android.widget.TextView"));
		assertTrue("Unable to detect the Calendar",CalendarValidation.exists());
	}
	/*public void testcCalendarOrientation() throws UiObjectNotFoundException, AndroidException { 
		
		getUiDevice().setOrientationLeft();
		getUiDevice().setOrientationNatural();
		
	}*/
	public void testdCalendarBack() throws UiObjectNotFoundException { 
		getUiDevice().pressBack();	
		
		UiObject BackfromCalendarValidation = new UiObject(new UiSelector().text("Welcome to your Unique Moments!"));
		assertTrue(BackfromCalendarValidation.exists());
	    
	}
	public void testeCalendarHome() throws UiObjectNotFoundException {
		UiObject Calendar = new UiObject(new UiSelector().text("Calendar"));
		Calendar.click();
		
		getUiDevice().pressHome();	
		
		UiObject HomefromCalendarValidation = new UiObject(new UiSelector().packageName("com.android.launcher"));
		assertTrue(HomefromCalendarValidation.exists());
	    
	}
}

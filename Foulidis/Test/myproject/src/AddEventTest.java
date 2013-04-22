
/**************************
 *  @author Foulidis Giannis
 *  Test Case: Add Event
 *  
 */


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
	    UiObject UMValidation = new UiObject(new UiSelector().packageName("com.example.myuniquemoments"));
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
        String a = editBox.getText();
        Pattern p = Pattern.compile("[a-zA-Z_0-9]");
        Matcher m = p.matcher(a);
        
        if (!(m.find()));
        {
        	fail("Invalid string"); //fail epidi to string dn einai kanoniko 
        }
		
	}

public void testdType() throws UiObjectNotFoundException

{
	

    UiObject txt = new UiObject(new UiSelector().description("EventType"));
    txt.setText("#$@##");
    String a = txt.getText();
    Pattern p = Pattern.compile("[a-zA-Z_0-9]");
    Matcher m = p.matcher(a);
    
    if (!m.find())
    {
    	fail("Invalid string");
    }
	
}
	
public void testeDateFormat() throws UiObjectNotFoundException
	
	{
		
	
        UiObject txt = new UiObject(new UiSelector().description("EventDate"));
        txt.setText("!!!!!!!");
        String a = txt.getText();
        Pattern p = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
        Matcher m = p.matcher(a);
        assertTrue (m.find()); //i imerominia prepei na einai tis morfis dd/mm/yyyy
     
		
	}
	

	



public void testfDescFormat() throws UiObjectNotFoundException

{
	

    UiObject txt = new UiObject(new UiSelector().description("EventDesc"));
    txt.setText("#$@##");
    String a = txt.getText();
    Pattern p = Pattern.compile("[a-zA-Z_0-9]");
    Matcher m = p.matcher(a);
    
    if (!m.find())
    {
    	fail("Invalid string");
    }
	
    
 
	
}

public void testgFieldsEmpty() throws UiObjectNotFoundException

{
	UiObject fieldName = new  UiObject(new UiSelector().className("android.widget.EditText"));
	UiObject fieldType = new  UiObject(new UiSelector().description("EventType"));
	UiObject fieldDate = new  UiObject(new UiSelector().description("EventDate"));
	UiObject fieldDesc = new  UiObject(new UiSelector().description("EvenDesc"));
	
	
	if (fieldName.getText().isEmpty() || fieldType.getText().isEmpty() || fieldDate.getText().isEmpty() || fieldDesc.getText().isEmpty())
	{
		fail("empty fields"); //kapio apo ta pedia einai adeio
	}
	
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

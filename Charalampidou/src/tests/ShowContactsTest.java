package tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class ShowContactsTest extends UiAutomatorTestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	//package exist
	public void testUMMenu() throws UiObjectNotFoundException
	{
		getUiDevice().pressHome();
		
		UiObject AppsBtn = new UiObject(new UiSelector().description("Apps"));
		AppsBtn.clickAndWaitForNewWindow();
		
		UiScrollable AView = new UiScrollable(new UiSelector().scrollable(true));
		AView.setAsHorizontalList();
		
		UiObject Umapp = AView.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		Umapp.clickAndWaitForNewWindow();
		
		UiObject PackUm = new UiObject(new UiSelector().packageName("gr.um.uniquemoments"));
	
		assertTrue("Package exists",PackUm.exists());
	}
	
	
	//view all contacts
	public void testViewAllContacts() throws UiObjectNotFoundException
	{
		getUiDevice().pressHome();
		
		UiObject AppsBtn = new UiObject(new UiSelector().description("Apps"));
		AppsBtn.clickAndWaitForNewWindow();
		
		UiScrollable AView = new UiScrollable(new UiSelector().scrollable(true));
		AView.setAsHorizontalList();
		
		UiObject Umapp = AView.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		Umapp.clickAndWaitForNewWindow();
		
		UiObject ContactsBtn= new UiObject(new UiSelector().text("Contacts"));
		ContactsBtn.clickAndWaitForNewWindow();
		
		UiObject RefreshBtn= new UiObject(new UiSelector().text("Refresh"));
		RefreshBtn.clickAndWaitForNewWindow();
		
		getUiDevice().pressBack();
		
		fail();
		//assertTrue("Unable to Show Contacts", ContactsBtn.isClickable());
	
	}	
	
	
}

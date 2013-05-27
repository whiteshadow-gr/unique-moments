package tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class ContactsTest extends UiAutomatorTestCase {

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
	
	//Create Contact
	public void testCreateNContact() throws UiObjectNotFoundException
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
		
		UiObject LongClickContactsList= new UiObject(new UiSelector().text("Charalampidou Vasileia"));
		LongClickContactsList.longClick();
		
		UiObject CreateNContacts= new UiObject(new UiSelector().text("Create New Contact"));
		CreateNContacts.clickAndWaitForNewWindow();
		
		UiObject editBoxName = new UiObject (new UiSelector().index(1));
		editBoxName.setText("Nick");
		
		UiObject editBoxNumber = new UiObject (new UiSelector().index(3));
		editBoxNumber.setText("692");
		
		UiObject CreateNContactBtn= new UiObject(new UiSelector().text("Create Contact"));
		CreateNContactBtn.clickAndWaitForNewWindow();
		
		UiObject Refresh2Btn= new UiObject(new UiSelector().text("Refresh"));
		Refresh2Btn.clickAndWaitForNewWindow();
		
		int i=0;
		for(i=0;i<3;i++)
		{
			getUiDevice().pressBack();
		}
		
		UiObject ContactNick= new UiObject(new UiSelector().text("Nick"));
		
		assertTrue("prosthiki epafis Nick", ContactNick.exists());
	
	}
	
	
	// Delete Contact
	public void testDeleteContact() throws UiObjectNotFoundException
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
		
		UiObject LongClickContactsList= new UiObject(new UiSelector().text("Nick"));
		LongClickContactsList.longClick();
		
		UiObject DeleteContact= new UiObject(new UiSelector().text("Delete Contact"));
		DeleteContact.clickAndWaitForNewWindow();
		
		UiObject Refresh2Btn= new UiObject(new UiSelector().text("Refresh"));
		Refresh2Btn.clickAndWaitForNewWindow();
		
		getUiDevice().pressBack();
		
		UiObject ContactNick= new UiObject(new UiSelector().text("Nick"));
		
		assertFalse("diagrafi epafis Nick", ContactNick.exists());
	
	}

}

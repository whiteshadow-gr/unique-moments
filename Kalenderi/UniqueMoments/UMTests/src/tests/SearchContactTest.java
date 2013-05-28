package tests;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class SearchContactTest extends UiAutomatorTestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testUMExists() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject UMValidation = new UiObject(new UiSelector().packageName("gr.um.uniquemoments"));
		getUiDevice().waitForIdle();
		assertTrue("Unable to run Unique Moments",UMValidation.exists());
	}
	
	public void testNumbersError() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		getUiDevice().waitForIdle();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		getUiDevice().waitForIdle();
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("2");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists());
	} 
	
	public void testAtSignError() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		getUiDevice().waitForIdle();
		appViews.setAsHorizontalList();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("@");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists());
	}
	
	public void testDiesiSignError() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		getUiDevice().waitForIdle();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("#");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists());
	}
	
	public void testStarSignError() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("*");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists());
	}
	
	public void testNonAlphanumericError() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		getUiDevice().waitForIdle();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("@#$%^&*()");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists()); 
	}
	
	public void testExistingContact() throws UiObjectNotFoundException{
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsHorizontalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		getUiDevice().waitForIdle();
		editBox.setText("desie");
		UiCollection ContactsList = new UiCollection(new UiSelector().className("android.widget.ListView") );
		int AllContacts = ContactsList.getChildCount();
		int exp = 1;
		assertEquals(exp , AllContacts);
	}
	
	public void testExistingContactList() throws UiObjectNotFoundException{
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("E");
		UiCollection ContactsList = new UiCollection(new UiSelector().className("android.widget.ListView") );
		int AllContacts = ContactsList.getChildCount();
		int exp = 3;
		assertEquals(exp , AllContacts);
	} 
	
	public void testExistContactList() throws UiObjectNotFoundException{
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("Ni");
		UiCollection ContactsList = new UiCollection(new UiSelector().className("android.widget.ListView") );
		int AllContacts = ContactsList.getChildCount();
		int exp = 2;
		assertEquals(exp , AllContacts);
	} 
	
	public void testEmptySearch() throws UiObjectNotFoundException{
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText(" ");
		UiCollection ContactsList = new UiCollection(new UiSelector().className("android.widget.ListView") );
		int AllContacts = ContactsList.getChildCount();
		int exp = 0;
		assertEquals(exp , AllContacts);
	} 
	
	public void testUnknownName() throws UiObjectNotFoundException{
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("Theodwra");
		UiCollection ContactsList = new UiCollection(new UiSelector().className("android.widget.ListView") );
		int AllContacts = ContactsList.getChildCount();
		int exp = 0;
		assertEquals(exp , AllContacts);
	} 
	
	public void testUnknownCelebration() throws UiObjectNotFoundException{
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("Roksanh");
		UiCollection ContactsList = new UiCollection(new UiSelector().className("android.widget.ListView") );
		int AllContacts = ContactsList.getChildCount();
		int exp = 0;
		assertEquals(exp , AllContacts);
	} 
	
	public void testExistingContactsAlfaios() throws UiObjectNotFoundException{
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("Alfaios");
		UiCollection ContactsList = new UiCollection(new UiSelector().className("android.widget.ListView") );
		int AllContacts = ContactsList.getChildCount();
		int exp = 1;
		assertEquals(exp , AllContacts);
	} 
	
	public void testExistingContactsVarsavia() throws UiObjectNotFoundException{
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("Varsavia");
		UiCollection ContactsList = new UiCollection(new UiSelector().className("android.widget.ListView") );
		int AllContacts = ContactsList.getChildCount();
		int exp = 0;
		assertEquals(exp , AllContacts);
	} 
	/*
	 public void testUMExistsVertical() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsVerticalList();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject UMValidation = new UiObject(new UiSelector().packageName("gr.um.uniquemoments"));
		assertTrue("Unable to run Unique Moments",UMValidation.exists());
	}
	
	public void testNumbersErrorVertical() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		getUiDevice().waitForIdle();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		getUiDevice().waitForIdle();
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsVerticalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("2");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists());
	} 
	
	public void testAtSignErrorVertical() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		getUiDevice().waitForIdle();
		appViews.setAsVerticalList();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("@");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists());
	}
	
	public void testDiesiSignErrorVertical() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		getUiDevice().waitForIdle();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsVerticalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("#");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists());
	}
	
	public void testStarSignErrorVertical() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsVerticalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("*");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists());
	}
	
	public void testNonAlphanumericErrorVertical() throws UiObjectNotFoundException {
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressHome();
		getUiDevice().waitForIdle();
		UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		allAppsButton.clickAndWaitForNewWindow();  
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
		appsTab.click();
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
		appViews.setAsVerticalList();
		getUiDevice().waitForIdle();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("@#$%^&*()");
		getUiDevice().waitForIdle();
		UiObject errorMessage = new UiObject (new UiSelector().text("errorMessage"));
		assertTrue("Unable to detect errorMessage",errorMessage.exists());
	}*/
}

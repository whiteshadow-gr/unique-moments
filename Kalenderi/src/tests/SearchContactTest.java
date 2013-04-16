package tests;

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
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject UMValidation = new UiObject(new UiSelector().packageName("com.example.myuniquemoments"));
		assertTrue("Unable to run Unique Moments",UMValidation.exists());
	}
	
	public void testNumbersError() throws UiObjectNotFoundException {
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("2");
		fail();
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
		appViews.setAsHorizontalList();
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject UMValidation = new UiObject(new UiSelector().packageName("com.example.myuniquemoments"));
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("@");
		fail();
	}
	
	public void testDiesiSignError() throws UiObjectNotFoundException {
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("#");
		fail();
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
		UiObject UniqueMommentsApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Unique Moments");
		UniqueMommentsApp.clickAndWaitForNewWindow();
		UiObject UMValidation = new UiObject(new UiSelector().packageName("com.example.myuniquemoments"));
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("*");
		fail();
	}
	
	public void testNonAlphanumericError() throws UiObjectNotFoundException {
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
		UiObject contactsButton = new UiObject(new UiSelector().text("Contacts"));
		contactsButton.clickAndWaitForNewWindow();
		UiObject editBox = new UiObject (new UiSelector().className("android.widget.EditText"));
		editBox.setText("@#$%^&*()");
		fail(); 
	}
}

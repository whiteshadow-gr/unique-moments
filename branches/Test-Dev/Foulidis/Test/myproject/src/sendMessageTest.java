import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class sendMessageTest extends UiAutomatorTestCase {
	
	
	


	
	
		
		
		
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
		    UiObject UMValidation = new UiObject(new UiSelector().packageName("gr.um.uniqumoments"));
		    assertTrue("Unable to run Unique Moments",UMValidation.exists());
			
			
			
			
			
		}
		
		
		public void testbOpenActivity() throws UiObjectNotFoundException
		
		
		{
			UiObject notishade = new UiObject(new UiSelector().className("android.widget.FrameLayout"));
			notishade.swipeDown(3);
			UiObject button = new UiObject(new UiSelector().className("android.view.View"));
			button.clickAndWaitForNewWindow();
			assertTrue(getUiDevice().getCurrentActivityName().equals("ActivityDailyEvents") );
			
			
			
			
			
			
			
		}
		
		
		public void testcSendSms() throws UiObjectNotFoundException
		
		{
			
			UiObject button2 = new UiObject(new UiSelector().className("android.widget.ListView").childSelector(new UiSelector().className("android.widget.TextView")));
			button2.longClick();
			UiObject button3 = new UiObject(new UiSelector().text("Send SMS"));
			button3.click();
			fail("");
			
			
		}
		
public void testdSendEmail() throws UiObjectNotFoundException
		
		{
			
			UiObject button2 = new UiObject(new UiSelector().className("android.widget.ListView").childSelector(new UiSelector().className("android.widget.TextView")));
			button2.longClick();
			UiObject button3 = new UiObject(new UiSelector().text("Send Email"));
			button3.click();
			fail("");
			
			
		}

	}




import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class sendMessageTest extends UiAutomatorTestCase {
	
	
	

	protected void setUp() throws Exception {
		super.setUp();
		
/* Kanoume eisagogi enos contact sto kinito me onoma to opio giortazei simera.
 * 
 * 
 * 
 * 		
 */
		
		/*File file = new File("si_en.xml");
		
		if (!file.exists())
		{
			URL url = new URL("http://www.eortologio.gr/rss/si_en.xml");
			ReadableByteChannel rbc = Channels.newChannel(url.openStream());
			FileOutputStream fos = new FileOutputStream("si_en.xml");
			fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		}
	    
		else
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			org.w3c.dom.Document document = builder.parse(file);
			org.w3c.dom.Element root = document.getDocumentElement();
			NodeList list = root.getElementsByTagName("title");
	       
	        NodeList subList = list.item(2).getChildNodes();
	        String s = subList.item(0).getNodeValue();
	       
	        if (!s.isEmpty())
	        {
	        ArrayList<String> aa = new ArrayList<String>();
	        aa.addAll(Arrays.asList(s.split(":")));
	        aa.remove(0);
	        String listString = "";
	        for (String ss : aa)
	        {
	            listString += ss + "\t";
	        }
	        
	        aa.clear();
	        aa.addAll(Arrays.asList(listString.split(",")));
	        
	        
	        
	        String contactName = aa.get(0).replaceAll("\\s","");
	        
	        //clear all contacts
	      Runtime.getRuntime().exec("adb shell pm clear com.android.providers.contacts");
	      
	      
	      //add contact
	      
	      
	      Runtime.getRuntime().exec("adb shell am start -a android.intent.action.INSERT -t vnd.android.cursor.dir/contact  " +
	      		"-e name "+contactName+" -e phone '6975829680'");
	        }
			
		 }
			*/
		
		
		}
	
	
	
	
		
		
		
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




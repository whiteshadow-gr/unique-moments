package tests;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ShowNotificationsTest extends UiAutomatorTestCase {
	
	public void testExistingContactAlfaios() throws UiObjectNotFoundException{
		getUiDevice().click(100,100);
		UiCollection NotificationsList = new UiCollection(new UiSelector().className("android.widget.ImageView") );
		int AllContacts = NotificationsList.getChildCount();
		int exp = 1;
		assertEquals(exp , AllContacts);
	}
	
	public void testExistingContactSinesios() throws UiObjectNotFoundException{
		getUiDevice().click(100,100);
		UiCollection NotificationsList = new UiCollection(new UiSelector().className("android.widget.ImageView") );
		int AllContacts = NotificationsList.getChildCount();
		int exp = 1;
		assertEquals(exp , AllContacts);
	}
	
	public void testExistingContactAleksandros() throws UiObjectNotFoundException{
		getUiDevice().click(100,100);
		UiCollection NotificationsList = new UiCollection(new UiSelector().className("android.widget.ImageView") );
		int AllContacts = NotificationsList.getChildCount();
		int exp = 0;
		assertEquals(exp , AllContacts);
	}
	
	public void testExistingContactElenh() throws UiObjectNotFoundException{
		getUiDevice().click(100,100);
		UiCollection NotificationsList = new UiCollection(new UiSelector().className("android.widget.ImageView") );
		int AllContacts = NotificationsList.getChildCount();
		int exp = 0;
		assertEquals(exp , AllContacts);
	}
	
	public void testExistingContactStefanos() throws UiObjectNotFoundException{
		getUiDevice().click(100,100);
		UiCollection NotificationsList = new UiCollection(new UiSelector().className("android.widget.ImageView") );
		int AllContacts = NotificationsList.getChildCount();
		int exp = 0;
		assertEquals(exp , AllContacts);
	}
}

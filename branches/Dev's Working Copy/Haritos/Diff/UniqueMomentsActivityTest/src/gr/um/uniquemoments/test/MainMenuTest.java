package gr.um.uniquemoments.test;

import gr.um.uniquemoments.ActivityMainMenu;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuTest extends ActivityInstrumentationTestCase2<ActivityMainMenu>
{


	private Activity myActivity;
	private Button ButtonContacts;
	private Button ButtonDailyEvents;
	private Button ButtonCalendar;
	private Button ButtonManageEvents;
	private TextView TextViewTitle;
	
	public MainMenuTest() 
	{
		super("gr.um.uniquemoments", ActivityMainMenu.class);
	}
	
	public void testPreConditionsMainMenu()
	{
		assertTrue(ButtonContacts.hasOnClickListeners());
		assertTrue(ButtonCalendar.hasOnClickListeners());
		assertTrue(ButtonDailyEvents.hasOnClickListeners());
		assertTrue(ButtonManageEvents.hasOnClickListeners());
		assertFalse(TextViewTitle.isClickable());
	}
	
	protected void setUp() throws Exception
	{
		super.setUp();
		setActivityInitialTouchMode(false);
	
		myActivity= getActivity();
		ButtonContacts = (Button) myActivity.findViewById(gr.um.uniquemoments.R.id.buttonContacts);
		ButtonCalendar = (Button) myActivity.findViewById(gr.um.uniquemoments.R.id.buttonCalendar);
		ButtonDailyEvents = (Button) myActivity.findViewById(gr.um.uniquemoments.R.id.buttonDailyEvents);
		ButtonManageEvents = (Button) myActivity.findViewById(gr.um.uniquemoments.R.id.buttonManageEvents);
		TextViewTitle = (TextView) myActivity.findViewById(gr.um.uniquemoments.R.id.textViewHeader);
	}
	
}

package gr.um.uniquemoments.test;

import gr.um.uniquemoments.ActivityManageEvents;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ManageEventsTest extends ActivityInstrumentationTestCase2<ActivityManageEvents> 
{

	private Activity myActivity;
	
	private EditText editName;
	private EditText editType;
	private EditText editDate;
	private EditText editDescription;
	
	private Button buttonCreateEvent;
	private Button buttonShowEvents;
	private Button buttonEditEvents;
	
	private TextView textHeader;
	private TextView textName;
	private TextView textType;
	private TextView textDate;
	private TextView textDescription;
	
	
	public ManageEventsTest() 
	{
		super("gr.um.uniquemoments", ActivityManageEvents.class);
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		myActivity = getActivity();
		
		editName = (EditText) myActivity.findViewById(gr.um.uniquemoments.R.id.editTextEventName);
		editType = (EditText) myActivity.findViewById(gr.um.uniquemoments.R.id.editTextEventType);
		editDate = (EditText) myActivity.findViewById(gr.um.uniquemoments.R.id.editTextEventDate);
		editDescription = (EditText) myActivity.findViewById(gr.um.uniquemoments.R.id.editTextEventDescription);
		
		buttonCreateEvent = (Button) myActivity.findViewById(gr.um.uniquemoments.R.id.buttonCreateEvent);
		buttonShowEvents = (Button) myActivity.findViewById(gr.um.uniquemoments.R.id.buttonShowEvents);
		buttonEditEvents = (Button) myActivity.findViewById(gr.um.uniquemoments.R.id.buttonEditEvents);
		
		textHeader = (TextView) myActivity.findViewById(gr.um.uniquemoments.R.id.textViewHeader);
		textName = (TextView) myActivity.findViewById(gr.um.uniquemoments.R.id.textViewEventName);
		textType = (TextView) myActivity.findViewById(gr.um.uniquemoments.R.id.textViewEventType);
		textDate = (TextView) myActivity.findViewById(gr.um.uniquemoments.R.id.textViewEventDate);
		textDescription = (TextView) myActivity.findViewById(gr.um.uniquemoments.R.id.textViewEventDescription);	
	}
	
	public void testPreconditionsManageEvents()
	{
		assertTrue(editName.isClickable());
		assertTrue(editType.isClickable());
		assertTrue(editDate.isClickable());
		assertTrue(editDescription.isClickable());
		
		//Should not pass! OnClick methods not implemented yet!!!
		assertTrue(buttonCreateEvent.hasOnClickListeners());
		assertTrue(buttonShowEvents.hasOnClickListeners());
		assertTrue(buttonEditEvents.hasOnClickListeners());
		
		assertTrue(textHeader.isShown());
		assertTrue(textName.isShown());
		assertTrue(textType.isShown());
		assertTrue(textDate.isShown());
		assertTrue(textDescription.isShown());
		
	}
	
	public void testOtherPreconditionsManageEvents()
	{
		assertTrue(editName.isFocusable());
		assertTrue(editType.isFocusable());
		assertTrue(editDate.isFocusable());
		assertTrue(editDescription.isFocusable());
		
		assertTrue(buttonCreateEvent.isEnabled());
		assertTrue(buttonShowEvents.isEnabled());
		assertTrue(buttonEditEvents.isEnabled());
	}
	
	
}

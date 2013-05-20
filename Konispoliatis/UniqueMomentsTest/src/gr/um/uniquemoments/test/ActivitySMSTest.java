package gr.um.uniquemoments.test;

import gr.um.sms.ActivitySMS;
import gr.um.uniquemoments.ActivityMainMenu;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

public class ActivitySMSTest extends 
ActivityInstrumentationTestCase2<ActivitySMS> 
{

	private Activity myActivity;
	private Button sendSMSTest;
	private EditText msgTxTTest;
	private EditText numTxTTest;
	
	public ActivitySMSTest() 
	{
		super("gr.um.sms", ActivitySMS.class);
	}
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		setActivityInitialTouchMode(false);
		myActivity= getActivity();
		sendSMSTest = (Button)myActivity.findViewById(gr.um.uniquemoments.R.id.SendMessage);
		msgTxTTest = (EditText)myActivity.findViewById(gr.um.uniquemoments.R.id.Message);
		numTxTTest = (EditText)myActivity.findViewById(gr.um.uniquemoments.R.id.Number);
	}
	public void testSMSActivity()
	{
		assertTrue(sendSMSTest.hasOnClickListeners());
		assertFalse(sendSMSTest.hasSelection());
		assertFalse(sendSMSTest.hasWindowFocus());
		assertTrue(sendSMSTest.hasFocusable());
		assertTrue(sendSMSTest.callOnClick());
		assertTrue(sendSMSTest.isClickable());
		assertFalse(sendSMSTest.isDrawingCacheEnabled());
		
		
		assertTrue(msgTxTTest.isEnabled());
		assertFalse(msgTxTTest.isActivated());
		assertTrue(msgTxTTest.isCursorVisible());
		assertFalse(msgTxTTest.isInTouchMode());
		assertTrue(msgTxTTest.isClickable());
		assertTrue(msgTxTTest.isFocusable());
		assertTrue(msgTxTTest.isClickable());
		assertFalse(msgTxTTest.isInputMethodTarget());
		assertFalse(msgTxTTest.isPressed());
		
		
		assertTrue(numTxTTest.isClickable());
		assertTrue(msgTxTTest.isEnabled());
		assertFalse(msgTxTTest.isActivated());
		assertTrue(msgTxTTest.isCursorVisible());
		assertFalse(msgTxTTest.isInTouchMode());
		assertTrue(msgTxTTest.isClickable());
		assertTrue(msgTxTTest.isFocusable());
		assertFalse(msgTxTTest.isInputMethodTarget());
		assertFalse(msgTxTTest.isPressed());
	}

}

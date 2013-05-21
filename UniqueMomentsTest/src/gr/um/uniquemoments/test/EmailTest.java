package gr.um.uniquemoments.test;

import gr.um.email.ActivityEmail;
import gr.um.uniquemoments.ActivityMainMenu;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

public class EmailTest extends ActivityInstrumentationTestCase2<ActivityEmail>

{

	private Activity myActivity;
	private Button emailbtn;
	private EditText emailTxT;
	
	public EmailTest() 
	{
		super("gr.um.email", ActivityEmail.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		
		super.setUp();
		myActivity= getActivity();
		emailbtn = (Button) myActivity.findViewById(gr.um.uniquemoments.R.id.sendBtn);
		emailTxT = (EditText) myActivity.findViewById(gr.um.uniquemoments.R.id.msgTxt);
	}
	
	public void testEmail()
	{
		assertTrue(emailbtn.hasOnClickListeners());
		assertTrue(emailbtn.isClickable());
		assertFalse(emailbtn.isSelected());
		assertFalse(emailbtn.hasSelection());
		
		assertTrue(emailTxT.isEnabled());
		assertTrue(emailTxT.isClickable());
	}

}

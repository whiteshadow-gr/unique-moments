package gr.um.uniquemoments.test;

import gr.um.email.EmailBuilder;
import gr.um.email.EmailSenderFactory;
import gr.um.email.EmailSenderTypes;
import gr.um.interfaces.IEmail;
import android.content.Intent;
import android.test.InstrumentationTestCase;

public class EmailUnitTest extends InstrumentationTestCase 
{

	protected void setUp() throws Exception 
	{
		super.setUp();
		
		
	}
	
	public void testSendEmailCorrectMailTo()
	{
		EmailBuilder builder = new EmailBuilder();
		String message = "myMsg";
		Intent emailIntent = builder.createEmailIntent(message);
		IEmail sender = EmailSenderFactory.getInstance(EmailSenderTypes.MOCK_EMAIL_SENDER, null);
		sender.sendEmail(emailIntent);
		String[] actual = sender.getIntentData();
		
		assertEquals(null, actual[0]);
	}

	public void testSendEmailCorrectHeader()
	{
		EmailBuilder builder = new EmailBuilder();
		String message = "myMsg";
		Intent emailIntent = builder.createEmailIntent(message);
		IEmail sender = EmailSenderFactory.getInstance(EmailSenderTypes.MOCK_EMAIL_SENDER, null);
		sender.sendEmail(emailIntent);
		String[] actual = sender.getIntentData();
		
		assertEquals("A message from Unique-Moments", actual[1]);
	}
	
	public void testSendEmailCorrectMessage()
	{
		EmailBuilder builder = new EmailBuilder();
		String message = "myMsg";
		Intent emailIntent = builder.createEmailIntent(message);
		IEmail sender = EmailSenderFactory.getInstance(EmailSenderTypes.MOCK_EMAIL_SENDER, null);
		sender.sendEmail(emailIntent);
		String[] actual = sender.getIntentData();
		
		assertEquals(message, actual[2]);
	}
}

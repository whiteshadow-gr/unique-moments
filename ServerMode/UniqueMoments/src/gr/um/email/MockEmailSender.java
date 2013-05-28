package gr.um.email;

import gr.um.interfaces.IEmail;
import android.content.Intent;
import android.os.Bundle;

public class MockEmailSender implements IEmail
{
	private String whereto;
	private String MailHeader;
	private String ActualMessage;
	public String[] actual;
	
	/**
	 * MockEmailSender() Constructor without parameters
	 */
	public MockEmailSender()
	{
		
	}
	
	/**
	 * sendEmail(Intent emailIntent) it adds messages to the email before starting the activity Email(Mock)
	 * @param emailIntent
	 */
	@Override
	public void sendEmail(Intent emailIntent) 
	{	
		MailHeader = emailIntent.getStringExtra("android.intent.extra.EMAIL");
		ActualMessage = emailIntent.getStringExtra("android.intent.extra.SUBJECT");
		whereto = emailIntent.getStringExtra("android.intent.extra.TEXT");
	}
	
	/**
	 * getIntentData() this functions collects the added messages and put it together in the email(Mock)
	 * @return data String
	 */
	@Override
	public String[] getIntentData() 
	{
		String[] data = new String[3];
		data[0] = MailHeader;
		data[1] = ActualMessage;
		data[2] = whereto;
		
		return data;
	}
}